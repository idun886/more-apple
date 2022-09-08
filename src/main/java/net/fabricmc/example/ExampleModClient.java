package net.fabricmc.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.example.ExampleMod;
import net.fabricmc.example.particle.ModParticles;
import net.fabricmc.example.particle.custom.PigLaserParticle;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ExampleModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


     //调用别的包里的注册方法在客户端里注册一个粒子特效
     ParticleFactoryRegistry.getInstance().register(ModParticles.PIG_LASER, PigLaserParticle.Factory::new);



//        //注册一个粒子
//        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
//            registry.register(new Identifier("first-fabric-mod", "pig_laser"));
//        }));
//
//        ParticleFactoryRegistry.getInstance().register(ExampleMod.PIG_LASER,FlameParticle.Factory::new);


    }

}