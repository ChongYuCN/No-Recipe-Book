package com.chongyu.norecipebook.client;

import com.chongyu.norecipebook.mixin.TexturedButtonWidgetAssessor;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;

public class NoRecipeBookClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //配方书
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if(screen instanceof InventoryScreen inventoryScreen){
                for (ClickableWidget button : Screens.getButtons(inventoryScreen) ){
                    TexturedButtonWidget buttonWidget = (TexturedButtonWidget)button;

//                    System.out.println("======"+ ((TexturedButtonWidgetAssessor)buttonWidget).getTexture().toString());//minecraft:textures/gui/recipe_button.png

                    if(((TexturedButtonWidgetAssessor)buttonWidget).getTexture().toString().equals("minecraft:textures/gui/recipe_button.png")) {
                        buttonWidget.visible =false;
                        break;
                    }
                }
            }
        });
    }
}
