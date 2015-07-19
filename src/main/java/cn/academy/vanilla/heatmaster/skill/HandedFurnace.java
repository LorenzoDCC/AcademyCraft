package cn.academy.vanilla.heatmaster.skill;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.MovingObjectPosition;
import cn.academy.ability.api.Skill;
import cn.academy.ability.api.ctrl.SkillInstance;
import cn.academy.ability.api.ctrl.action.SyncActionInstant;
import cn.academy.ability.api.ctrl.instance.SkillInstanceInstant;
import cn.academy.ability.api.data.AbilityData;
import cn.academy.ability.api.data.CPData;
import cn.academy.vanilla.heatmaster.skill.WorldHeater.WorldHeaterAction;
import cn.liutils.util.mc.BlockFilters;
import cn.liutils.util.raytrace.Raytrace;

public class HandedFurnace extends Skill
{
	static HandedFurnace instance;
	public HandedFurnace()
	{
		super("handedfurnace",1);
		// TODO level
		instance=this;
	}
	
	@Override
    public SkillInstance createSkillInstance(EntityPlayer player)
	{
		return new SkillInstanceInstant().addExecution(new HandedFurnaceAction());
	}
	
	// class

	public static class HandedFurnaceAction extends SyncActionInstant
	{

		@Override
		public boolean validate()
		{
			AbilityData aData= AbilityData.get(player);
			CPData cpData= CPData.get(player);
			//Check if Itemstack can be semlted
			if(FurnaceRecipes.smelting().getSmeltingResult(this.player.getCurrentEquippedItem())==null) return false;
			return cpData.perform(getOverload(aData),getConsumption(aData));
		}

		@Override
		public void execute()
		{
			System.out.println("Invoked");
			AbilityData aData= AbilityData.get(player);
			ItemStack smeltedStack=player.getCurrentEquippedItem().splitStack(1);
			ItemStack resultStack=FurnaceRecipes.smelting().getSmeltingResult(smeltedStack);
			float exp=FurnaceRecipes.smelting().func_151398_b(resultStack);
			
			//TODO exp fix
			//player.addExperience(exp);
			//player.worldObj.spawnEntityInWorld(new EntityXPOrb(player.worldObj,player.posX,player.posY + 0.5D, player.posZ + 0.5D, j));
			/*player.experience+=exp;
			if(1<=player.experience)
			{
				player.experience-=1;
				player.addExperienceLevel(1);
			}*/
			
			FMLCommonHandler.instance().firePlayerSmeltedEvent(player, resultStack);
			player.dropItem(resultStack.getItem(),resultStack.stackSize);
			 
			if (!isRemote)
			{
				System.out.println("Smelted");
			} else
			{
				spawnEffects();
			}
		}

		private static float getOverload(AbilityData data)
		{
			/*
			 * return instance.pipeFloat("overload",
			 * instance.getFunc("overload")
			 * .callFloat(data.getSkillExp(instance)));
			 */
			// TODO ripple support
			return 1.0F;
		}

		private static float getConsumption(AbilityData data)
		{
			/*
			 * return instance.pipeFloat("cp", instance.getFunc("consumption")
			 * .callFloat(data.getSkillExp(instance)));
			 */
			// TODO ripple support
			return 10.0F;
		}

		@SideOnly(Side.CLIENT)
		private void spawnEffects()
		{
			System.out.println("Effects Spawned");
			// TODO Effects
		}
	}
}
