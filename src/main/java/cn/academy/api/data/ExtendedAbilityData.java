/**
 * Copyright (c) Lambda Innovation, 2013-2015
 * 本作品版权由Lambda Innovation所有。
 * http://www.li-dev.cn/
 *
 * AcademyCraft is open-source, and it is distributed under 
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * AcademyCraft是一个开源项目，且遵循GNU通用公共授权协议。
 * 在遵照该协议的情况下，您可以自由传播和修改。
 * http://www.gnu.org/licenses/gpl.html
 */
package cn.academy.api.data;

import net.minecraft.nbt.NBTTagCompound;

/**
 * This class stores information within ability data.
 * @author WeathFolD
 */
public abstract class ExtendedAbilityData {
	
	boolean dirty = true;
	
	public abstract void fromNBT(NBTTagCompound nbt);
	public abstract void toNBT(NBTTagCompound nbt);

	/**
	 * Mark this data as dirty and synchronize it to client next data synch.
	 */
	public void markDirty() {
		dirty = true;
	}
}