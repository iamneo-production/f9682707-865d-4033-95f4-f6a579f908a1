#!/bin/bash
if [ -d "/home/coder/project/workspace/springapp/" ]
then
    echo "project folder present"
    # checking for src folder
    if [ -d "/home/coder/project/workspace/springapp/src/" ]
    then
        cp -r /home/coder/project/workspace/junit/test /home/coder/project/workspace/springapp/src/;
    cd /home/coder/project/workspace/springapp/ || exit;
    mvn clean test;
    else
        echo "testCreateProduct FAILED";
        echo "testGetProductAll FAILED";
        echo "testGetProductById FAILED";
        echo "testCreateInventory FAILED";
        echo "testGetInventoryAll FAILED";
        echo "testGetInventoryById FAILED";
        echo "testGetShipmentAll FAILED";
        echo "testGetSalesById FAILED";
        echo "testGetPurchaseAll FAILED";
        echo "testGetPurchaseById FAILED";
    fi
else   
        echo "testCreateProduct FAILED";
        echo "testGetProductAll FAILED";
        echo "testGetProductById FAILED";
        echo "testCreateInventory FAILED";
        echo "testGetInventoryAll FAILED";
        echo "testGetInventoryById FAILED";
        echo "testGetShipmentAll FAILED";
        echo "testGetSalesById FAILED";
        echo "testGetPurchaseAll FAILED";
        echo "testGetPurchaseById FAILED";
fi