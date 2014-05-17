package themike.artifacts.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityStoneGolem extends EntityIronGolem implements IBossDisplayData {

	public EntityStoneGolem(World par1World) {
		super(par1World);
		this.tasks.taskEntries.set(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, true));
	}
	
	@Override
    protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0D);
	}

}
