package cn.academy.vanilla.heatmaster;

import cn.academy.ability.api.Category;
import cn.academy.knowledge.KnowledgeData;
import cn.academy.vanilla.ModuleVanilla;
import cn.academy.vanilla.electromaster.skill.ArcGen;
import cn.academy.vanilla.electromaster.skill.MagManip;
import cn.academy.vanilla.electromaster.skill.MagMovement;
import cn.academy.vanilla.electromaster.skill.MineDetect;
import cn.academy.vanilla.electromaster.skill.Railgun;
import cn.academy.vanilla.heatmaster.skill.*;

public class CatHeatMatser extends Category
{
	public WorldHeater worldhearter;
	public HandedFurnace handedfurnace;
	
	public CatHeatMatser()
	{
		super("heat_master");

		defineTypes("default","passive");

		addSkill("default",worldhearter= new WorldHeater());
		addSkill("default",handedfurnace= new HandedFurnace());
		
		//KnowledgeData.addKnowledges(new String[] {});
		ModuleVanilla.addGenericSkills(this);
	}
}
