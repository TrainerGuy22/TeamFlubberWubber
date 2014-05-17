package themike.artifacts.entities;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAITasks.EntityAITaskEntry;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityStoneGolem extends EntityIronGolem implements IBossDisplayData {

	public EntityStoneGolem(World par1World) {
		super(par1World);
		
		this.tasks.removeTask(new EntityAIAttackOnCollide(this, 1.0D, true));
		EntityAIBase one = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false);
		this.tasks.addTask(1, one);
		
		this.targetTasks.removeTask(new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, true, IMob.mobSelector));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}
	
	@Override
    protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(125.0D);
	}

}
