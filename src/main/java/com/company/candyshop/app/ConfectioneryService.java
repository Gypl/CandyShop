package com.company.candyshop.app;

import com.company.candyshop.entity.Confectionery;
import com.company.candyshop.entity.Ingredient;
import com.company.candyshop.entity.Resource;
import io.jmix.core.DataManager;
import io.jmix.core.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ConfectioneryService {
    @Autowired
    private DataManager dataManager;

    // Надо узнать сколько приготовлено новых изделий и вычесть их количество из ресурсов
    // cofectionery - новый экземпляр сущности
    // Загружаем старый список ресурсов. Запоминаем id старого изделия.
    // Загружаем список ингредиентов. Устанавливаем новое значение количества ресурса.
    // Удаляем старую запись изделия и прибавляем старое количество изделий новой записи.
    public boolean consumeResources(Confectionery confectionery){
        int cookedNumber = 0;
        UUID confectioneryOldUUID = null;
        boolean existFlag = false;
        List<Confectionery> confectioneryOldList = confectionery.getCandyShop().getConfectioneries();
        if (confectioneryOldList != null) {
            for (Confectionery confOld : confectioneryOldList) {
                if (confOld.getConfecrioneryName().equals(confectionery.getConfecrioneryName())) {
                    cookedNumber = confOld.getNumber();
                    confectioneryOldUUID = confOld.getId();
                    existFlag = true;
                    if (confectioneryOldUUID.equals(confectionery.getId()))
                        return true;
                }
            }
        }

        // Мапа для проверки наличия нужного количества ресусов.
        List<Resource> resourceList = confectionery.getCandyShop().getResources();
        Map<String,Double> resources = new HashMap<>();
        if (resourceList != null){
            for (Resource res : resourceList){
                resources.put(res.getResourceName(),res.getAmount());
            }
        } else return false;

        // Проверка наличия нужного количества ресурсов.
        List<Ingredient> ingredientList = confectionery.getConfecrioneryName().getIngredients();
        if (ingredientList != null){
            for (Ingredient ingr : ingredientList) {
                String ingredientName = ingr.getIngredientName().getResourceName();
                double curentAmount = resources.get(ingr.getIngredientName().getResourceName());
                double newAmount = curentAmount - ingr.getAmount();
                if (newAmount < 0)
                    return false;
                resources.replace(ingredientName, curentAmount, newAmount);
            }
            for (double value : resources.values()){
                if (value < 0)
                    return false;
            }
        }

        if (ingredientList != null){
            for (Ingredient ingred : ingredientList){
                Resource resource = ingred.getIngredientName();
                double newAmount = resource.getAmount() - (ingred.getAmount() * confectionery.getNumber());
                if (newAmount < 0)
                    return false;
                resource.setAmount(newAmount);
                dataManager.save(resource);
            }
        }
        confectionery.setNumber(confectionery.getNumber() + cookedNumber);
        if (existFlag)
           dataManager.remove(Id.of(confectioneryOldUUID, Confectionery.class));
        return true;
    }
}