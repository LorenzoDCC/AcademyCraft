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
package cn.academy.terminal;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import cn.academy.terminal.client.TerminalUI;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author WeAthFolD
 */
public class AppEnvironment {
	
	/*
	 * Instances to be injected when startup
	 */
	public App app;
	public TerminalUI terminal;

	/**
	 * Called just before environment is activated on client side. Load the data.
	 */
	public void onStart() {}
	
	protected App getApp() {
		return app;
	}
	
	protected TerminalUI getTerminal() {
		return terminal;
	}
	
	@SideOnly(Side.CLIENT)
	protected EntityPlayer getPlayer() {
		return Minecraft.getMinecraft().thePlayer;
	}
	
}
