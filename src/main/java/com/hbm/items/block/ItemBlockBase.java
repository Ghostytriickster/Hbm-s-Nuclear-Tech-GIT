package com.hbm.items.block;

import java.util.List;

import com.hbm.blocks.BlockEnumMulti;
import com.hbm.blocks.BlockMulti;
import com.hbm.blocks.ITooltipProvider;
import com.hbm.util.EnumUtil;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBase extends ItemBlock {

	public ItemBlockBase(Block block) {
		super(block);
		
		if(block instanceof BlockMulti) {
			this.setMaxDamage(0);
			this.setHasSubtypes(true);
		}
	}
	
	@Override
	public int getMetadata(int meta) {
		if(field_150939_a instanceof BlockMulti)
			return meta;
		else
			return super.getMetadata(meta);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		
		if(field_150939_a instanceof BlockEnumMulti && ((BlockEnumMulti)field_150939_a).multiName) {
			
			Enum num = EnumUtil.grabEnumSafely(((BlockEnumMulti)field_150939_a).theEnum, stack.getItemDamage());
			return super.getUnlocalizedName() + "." + num.name().toLowerCase();
		} else {
			return super.getUnlocalizedName(stack);
		}
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool) {
		
		if(field_150939_a instanceof ITooltipProvider) {
			((ITooltipProvider) field_150939_a).addInformation(itemstack, player, list, bool);
		}
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		
		if(field_150939_a instanceof ITooltipProvider) {
			return ((ITooltipProvider) field_150939_a).getRarity(stack);
		}
		
		return EnumRarity.common;
	}
}
