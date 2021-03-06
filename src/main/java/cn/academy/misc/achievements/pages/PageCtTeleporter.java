package cn.academy.misc.achievements.pages;

import cn.academy.ability.ModuleAbility;
import cn.academy.ability.api.CategoryManager;
import cn.academy.misc.achievements.ItemAchievement;
import cn.academy.misc.achievements.aches.ACAchievement;
import cn.academy.misc.achievements.aches.AchAbility;
import cn.academy.misc.achievements.aches.AchEvLevelChange;
import cn.academy.misc.achievements.aches.AchEvSkillLearn;
import cn.academy.vanilla.teleporter.CatTeleporter;

/**
 * @author EAirPeter
 */
public final class PageCtTeleporter extends PageCategory<CatTeleporter> {

	private final ACAchievement aLv1;
	private final ACAchievement aLv2;
	private final ACAchievement aLv3;
	private final ACAchievement aLv4;
	private final ACAchievement aLv5;

	private final ACAchievement aThreateningTeleport;
	private final ACAchievement aCriticalAttack;
	private final ACAchievement aIgnoreBarrier;
	private final ACAchievement aFlashing;
	private final ACAchievement aMastery;
	
	public PageCtTeleporter() {
		super((CatTeleporter) CategoryManager.INSTANCE.getCategory("teleporter"));
		add(new ACAchievement[] {
			aLv1 = new AchEvLevelChange(1, category.dimFolding, "lv1", 0, 0, null),
			aLv2 = new AchEvLevelChange(2, category.penetrateTP, "lv2", 2, 0, aLv1),
			aLv3 = new AchEvLevelChange(3, category.locTP, "lv3", 2, 2, aLv2),
			aLv4 = new AchEvLevelChange(4, category.spaceFluct, "lv4", -2, 2, aLv3),
			aLv5 = new AchEvLevelChange(5, category.flashing, "lv5", -2, 0, aLv4),
		});
		add(new ACAchievement[] {
			aThreateningTeleport = new AchAbility(category.threateningTP, -3, -1, null),
			//Icon pending
			aCriticalAttack = new AchAbility(category, "critical_attack", -3, 1, aThreateningTeleport),
			aIgnoreBarrier = new AchAbility(category.penetrateTP, "ignore_barrier", -3, 3, aCriticalAttack),
			aFlashing = new AchAbility(category.flashing, -1, 3, aIgnoreBarrier),
			//Icon pending
			aMastery = new AchAbility(category, "mastery", 1, 3, aFlashing),
		});
	}
	
}
