package themike.artifacts.client.entity;

import themike.artifacts.entities.EntityStoneGolem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderIronGolem;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderStoneGolem extends RenderIronGolem {
	
	public RenderStoneGolem() {
		super();
	}
	
	@Override
    protected ResourceLocation getEntityTexture(EntityIronGolem entity) {
        return new ResourceLocation("artifacts", "textures/entity/stone_golem.png");
    }
	
    @Override
    public void doRender(EntityIronGolem entity, double blarg1, double blarg2, double blarg3, float blarg4, float blarg5) {
		BossStatus.setBossStatus((EntityStoneGolem) entity, false);
		super.doRender(entity, blarg1, blarg2, blarg3, blarg4, blarg5);
	}

}
