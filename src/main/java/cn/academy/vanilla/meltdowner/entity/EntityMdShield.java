/**
 * Copyright (c) Lambda Innovation, 2013-2015
 * 本作品版权由Lambda Innovation所有。
 * http://www.li-dev.cn/
 *
 * This project is open-source, and it is distributed under
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * 本项目是一个开源项目，且遵循GNU通用公共授权协议。
 * 在遵照该协议的情况下，您可以自由传播和修改。
 * http://www.gnu.org/licenses/gpl.html
 */
package cn.academy.vanilla.meltdowner.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cn.academy.vanilla.meltdowner.client.render.RenderMdShield;
import cn.annoreg.core.Registrant;
import cn.annoreg.mc.RegEntity;
import cn.liutils.entityx.EntityAdvanced;
import cn.liutils.util.helper.Motion3D;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author WeAthFolD
 */
@SideOnly(Side.CLIENT)
@Registrant
@RegEntity(clientOnly = true)
@RegEntity.HasRender
public class EntityMdShield extends EntityAdvanced {
	
	@RegEntity.Render
	public static RenderMdShield renderer;
	
	public static final float SIZE = 1.8f;
	
	// Intrusive render states
	public float rotation;
	public long lastRender;
	
	final EntityPlayer player;

	public EntityMdShield(EntityPlayer _player) {
		super(_player.worldObj);
		player = _player;
		this.setSize(SIZE, SIZE);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		Motion3D mo = new Motion3D(player, true).move(1);
		mo.py -= 0.5;
		setPosition(mo.px, mo.py, mo.pz);
		
		this.rotationYaw = player.rotationYawHead;
		this.rotationPitch = player.rotationPitch;
	}
	
	@Override
	public boolean shouldRenderInPass(int pass) {
		return pass == 1;
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tag) {}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tag) {}

}
