package io.github.dftrakesh.cloverrest;

import io.github.dftrakesh.cloverrest.model.inventoery.option.OptionResponse;

import java.util.HashMap;

import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.CLOVER_REST_REGION_US_AND_CANADA;

public class Test {

    public static void main(String[] args) {

        AccessCredentials accessCredentials = new AccessCredentials();
        accessCredentials.setRegion(CLOVER_REST_REGION_US_AND_CANADA);
        accessCredentials.setAccessToken("fd21a9fe-0f34-09f7-0f70-241ae767b4e0");
        accessCredentials.setMerchantId("9J49JAJEG55M1");

//        CloverRestToken cloverRestToken = new CloverRestToken(accessCredentials);
//        HashMap<String, String> map = new HashMap<>();
//        map.put("client_id", "KPBYTREJYA8W4");
//        map.put("client_secret", "139cc026-7c44-146c-5d75-8b9545b4eab2");
//        map.put("code", "e1ef36d7-3ab0-0b15-8611-45d7174974f4");
//
//        AccessToken accessToken = cloverRestToken.getAccessToken(map);
//        System.out.println("accessToken: " +accessToken);

//        CloverRestItem cloverRestItem = new CloverRestItem(accessCredentials);
//        ItemResponse items = cloverRestItem.getItems(new HashMap<>());
//        System.out.println("items" + items);

//        ItemRequest itemRequest = new ItemRequest();
//        itemRequest.setName("Caesar Salad");
//        itemRequest.setPrice(0.12);
//        itemRequest.setColor("#FA6400");
//
//        Element items = cloverRestItem.createItems(itemRequest);
//        System.out.println("items" + items);

//        CloverRestItemGroup cloverRestItemGroup = new CloverRestItemGroup(accessCredentials);
//        HashMap<String, String> map = new HashMap<>();
//        map.put("expand", "attributes,items");
//        ItemGroupResponse itemsGroups = cloverRestItemGroup.getItemsGroups(map);

//        ItemGroupRequest itemGroupRequest = new ItemGroupRequest();
//        itemGroupRequest.setId("HEDEVZPGWNMXA");
//        itemGroupRequest.setName("DFT Test API1");
//        ItemGroupElement orUpdateItemGroup = cloverRestItemGroup.updateItemGroup(itemGroupRequest, "HEDEVZPGWNMXA");
//        System.out.println("itemsGroups" + orUpdateItemGroup);

        CloverRestOption cloverRestOption = new CloverRestOption(accessCredentials);
        OptionResponse allOption = cloverRestOption.getAllOption(new HashMap<>());
        System.out.println("allOption" + allOption);
    }
}