package com.gendeathrow.hatchery.core.jei.eggmachine;

import java.util.ArrayList;
import java.util.List;

import com.gendeathrow.hatchery.api.crafting.EggMachineRecipe;
import com.gendeathrow.hatchery.core.init.ModItems;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class EggMachineWrapper extends BlankRecipeWrapper 
{
	private final List<ItemStack> outputs;
	private final List<ItemStack>  inputs;
	private final List<ItemStack>  allEggs;
	
	
	public EggMachineWrapper(EggMachineRecipe recipe) 
	{
		this.outputs = new ArrayList<ItemStack>();
		this.inputs = new ArrayList<ItemStack>();
		this.allEggs = new ArrayList<ItemStack>(recipe.getAllEggs());
		
		this.inputs.addAll(recipe.getInputItem());
		this.inputs.add(new ItemStack(ModItems.chickenmachine));
		
		
		this.outputs.add(new ItemStack(ModItems.prizeEgg));

	}

	@Override
	public void drawInfo(Minecraft arg0, int arg1, int arg2, int arg3, int arg4) 
	{
		
	}

	@Override
	public void getIngredients(IIngredients ingredients) 
	{
        ingredients.setInputs(ItemStack.class, inputs);
        ingredients.setOutputs(ItemStack.class, outputs);
	}

	public List<ItemStack> getAllEggs(){
		return allEggs;
	}
	
	public List<ItemStack> getInput() {
		return inputs;
	}

	public List<ItemStack> getOutput() {
		return outputs;
	}
}
