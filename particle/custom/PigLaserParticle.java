package net.fabricmc.example.particle.custom;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;

public class PigLaserParticle extends SpriteBillboardParticle {


    protected PigLaserParticle(ClientWorld clientWorld, double xCoord, double yCoord, double zCoord,
                               SpriteProvider spriteSet, double xd, double yd, double zd) {
        super(clientWorld, xCoord, yCoord, zCoord, xd, yd, zd);

        this.velocityMultiplier = 0.6F;         //速度
        this.x = xd;
        this.y = yd;
        this.z = zd;
        this.scale *= 0.75F;
        this.maxAge = 20;
        this.setSpriteForAge(spriteSet);

    }

    @Override
    public void tick(){
        super.tick();
        //调用粒子特效淡入淡出方法
        fadeOut();
    }
    private void fadeOut(){
        this.alpha = (-(1/(float)maxAge) * age +1);
    }



    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }




    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType>{

        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteSet){
            this.sprites = spriteSet;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld clientWorld, double x, double y, double z,
                                       double dx, double dy, double dz){
            return new PigLaserParticle(clientWorld,x,y,z,this.sprites,dx,dy,dz);
        }

    }


}
