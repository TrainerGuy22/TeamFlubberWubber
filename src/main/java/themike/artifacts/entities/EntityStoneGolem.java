package themike.artifacts.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITasks.EntityAITaskEntry;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityStoneGolem extends EntityIronGolem implements IBossDisplayData {

	public EntityStoneGolem(World par1World) {
		super(par1World);
		this.tasks.removeTask(new EntityAIAttackOnCollide(this, 1.0D, true));
		EntityAIBase one = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, true);
		this.tasks.addTask(1, one);
	}
	
	@Override
    protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0D);
	}

}
