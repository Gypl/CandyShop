# CandyShop

Релизованы связи сущностей.

![image](https://user-images.githubusercontent.com/55764206/178550349-1aa7f316-7b4c-44d8-9d9a-0daebc4b16a9.png)

- [X] Разработать следующие сущности и атрибуты:

    *	Кондитерская
          *	Список технологических карт
          *	Список компонентов
          *	Список готовых изделий
          *	Список закупок
          *	Список заказов
    *	Технологическая карта
          *	Название изделия
          *	Список компонентов
    *	Компонент
          *	Название (например, мука, яйцо и т.д.)
          *	Количество
          *	Размерность
    *	Заказ
          *	Номер заказа
          *	Список изделий
          *	Признак готовности к выполнению
          *	Признак выполнения

- [X] Реализовать необходимые экраны просмотра и редактирования для сущностей.

- [X] Реализовать механизм создания и выполнения заказа.

- [X] Для приготовления изделия используются ресурсы, имеющиеся в кондитерской. При создании нового изделия работает следующий механизм:
    - [X] Для изготовления нужно необходимое количество компонентов, указанных в тех. карте.
    - [X] При создании изделия количество компонентов должно вычитаться из тех, которые имеются в кондитерской.
    - [X] Если компонентов не хватает – изделия создать нельзя, должно выдаваться сообщение.

- [X] Для создания заказа используется такой же механизм:  
    - [X] Признак готовности к выполнению должен выставляться, если нужное количество компонентов доступно в кондитерской.
    - [X] Признак выполнения заказа выставляется по кнопке, если готовые изделия есть в списке кондитерской.
    - [X] При нажатии на кнопку готовые изделия должны удаляться из списка готовых. 
