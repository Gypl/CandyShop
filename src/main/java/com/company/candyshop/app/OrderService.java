package com.company.candyshop.app;

import com.company.candyshop.entity.*;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {
    @Autowired
    private DataManager dataManager;

    public long getNewOrderNumber(){
        long result = 0;

        List<Order> orderList = dataManager.load(Order.class).all().fetchPlan("order-max-number").list();
        if (orderList.size() != 0) {
            for (Order order : orderList) {
                long orderNumber = order.getOrderNumber();
                if (result < orderNumber)
                    result = orderNumber;
            }
        }
        return result + 1;
    }
    //Создаём список заказанных изделий, список изделий для мапы изделий.
    // Вычитаем из мапы каждую запись, если меньше то не готовы.
    public boolean checkHaveConfectioneries(Order order){
        List<OrderedConfectionery> orderedConfectioneryList = order.getOrederedConfectioneries();
        List<Confectionery> confectioneryList = order.getCandyShop().getConfectioneries();
        Map<FlowSheet,Integer> confectioneries = new HashMap<>();
        if (confectioneryList.size() != 0) {
            for (Confectionery conf : confectioneryList) {
                confectioneries.put(conf.getConfecrioneryName(), conf.getNumber());
            }
        } else return false;

        if (orderedConfectioneryList.size() != 0) {
            for (OrderedConfectionery oc : orderedConfectioneryList) {
                FlowSheet flowSheetName = oc.getConfectioneryName();
                int curentNumber = confectioneries.get(oc.getConfectioneryName());
                int newNumber = curentNumber - oc.getNumber();
                confectioneries.replace(flowSheetName, curentNumber, newNumber);
            }
            for (double val : confectioneries.values()) {
                if (val < 0)
                    return false;
            }
            return true;
        }
        return false;
        ////////////////////////////
        /*
        if (orderedConfectioneryList.size() != 0){
            for (OrderedConfectionery oc : orderedConfectioneryList){
                Confectionery confectionery = dataManager.load(Confectionery.class)
                        .query("select c from Confectionery c where c.confectioneryName = :cn")
                        .parameter("cn",oc.getConfectioneryName())
                        .fetchPlan("confectionery-fetch-plan")
                        .one();
                if (confectionery.getNumber() < oc.getNumber())
                    return false;
            }
            return true;
        }
        return false;
        */
    }

    public boolean checkHaveResources(Order order){
        CandyShop candyShop = order.getCandyShop();
        List<OrderedConfectionery> orderedConfectioneryList = order.getOrederedConfectioneries();
        /*List<Resource> resourceList = dataManager.load(Resource.class)
                .query("select r from Resource r where r.candyShop = :cs")
                .parameter("cs",candyShop).fetchPlan("resource-fetch-plan").list();*/
        List<Resource> resourceList = candyShop.getResources();
        Map<String,Double> resources = new HashMap<>();
        if (resourceList.size() != 0){
            for (Resource res : resourceList){
                resources.put(res.getResourceName(),res.getAmount());
            }
        } else return false;
        List<Ingredient> ingredientList = new ArrayList<>();
        if (orderedConfectioneryList.size() != 0){
            for (OrderedConfectionery oc : orderedConfectioneryList){
                ingredientList.addAll(oc.getConfectioneryName().getIngredients());
            }
            for (Ingredient ingr : ingredientList) {
                String ingredientName = ingr.getIngredientName().getResourceName();
                double curentAmount = resources.get(ingr.getIngredientName().getResourceName());
                double newAmount = curentAmount - ingr.getAmount();
                resources.replace(ingredientName, curentAmount, newAmount);
            }
            for (double val : resources.values()){
                if (val < 0)
                    return false;
            }
        }
        return true;
    }

    public void consumeConfectioneries(Order order){
        List<OrderedConfectionery> orderedConfectioneryList = order.getOrederedConfectioneries();
        List<Confectionery> confectioneryList = order.getCandyShop().getConfectioneries();
        Map<FlowSheet,UUID> confectioneries = new HashMap<>();

        if (orderedConfectioneryList.size() != 0 || confectioneryList.size() != 0) {
            for (Confectionery conf : confectioneryList) {
                confectioneries.put(conf.getConfecrioneryName(), conf.getId());
            }
            for (OrderedConfectionery oc : orderedConfectioneryList) {
                Confectionery confectionery = dataManager.load(Confectionery.class)
                        .id(confectioneries.get(oc.getConfectioneryName())).one();
                int curentNumber = confectionery.getNumber();
                int newNumber = curentNumber - oc.getNumber();
                confectionery.setNumber(newNumber);
            }
        }
    }

    //Надо узнать сколько приготовлено новых изделий и вычесть их количество из ресурсов
    public boolean consumeResources(Confectionery confectionery, int cookedNumber){
        //int cookedNumber = 0;
        List<Ingredient> ingredientList = confectionery.getConfecrioneryName().getIngredients();
        //Map<Resource,Double> resources = new HashMap<>();
        if (ingredientList.size() != 0){
            for (Ingredient ingred : ingredientList){
                //resources.put(ingred.getIngredientName(),ingred.getAmount());
                Resource resource = ingred.getIngredientName();
                double newAmount = resource.getAmount() - (ingred.getAmount() * cookedNumber);
                if (newAmount < 0)
                    return false;
                resource.setAmount(newAmount);
            }
        }
        return true;
    }
}