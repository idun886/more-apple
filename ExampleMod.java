package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.particle.ModParticles;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleType;
import net.minecraft.resource.Resource;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.commons.codec.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.client.item.*;

//这个类 使用了 mod初始化接口 必须实现初始化接口里的一个方法 onInitializer 初始化方法
public class ExampleMod implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.

    //打印日志
    public static final Logger LOGGER = LoggerFactory.getLogger("first-fabric-mod");

    //创建一个物品组 这个物品组 里面的参数 是 你的modid 和 物品组的名称  在assets文件夹里创建一个对应的modid文件夹
 //   public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
//            general
//            new Identifier("first-fabric-mod","general"),
//            () -> new ItemStack(Blocks.COBBLESTONE));

    public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(
            new Identifier("first-fabric-mod", "generaltwo"))
            .icon(() -> new ItemStack(Items.BOWL))
            .build();

    //    新增物品实例
    //    public static final Item FABRIC_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    //    创建物品过程  我们首先定义一个public类 FabricItem 在里面写进去相应的方法  然后再ExampleMod这个类里进行实例化  如下代码


    //实例化物品组 为下面注册物品做准备
    //下面这个是 直接构造了food类型的item并且赋给了许多的属性
    //这里构建了一个钻石苹果

    public static final Item DIAMOND_APPLE = new Item(new FabricItemSettings().food((new FoodComponent
            .Builder()
            .hunger(20)
            .saturationModifier(20)
            .alwaysEdible()
            .statusEffect(
                    new StatusEffectInstance(StatusEffects.STRENGTH,6000,4,true,true,true),
                    1.0F)
            .statusEffect(
                    new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,6000,4,true,true,true),
                    1.0F)
            .statusEffect(
                    new StatusEffectInstance(StatusEffects.REGENERATION,6000,4,true,true,true),
                    1.0F)
            .statusEffect(
                    new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,6000,4,true,true,true),
                    1.0F)
            .statusEffect(
                    new StatusEffectInstance(StatusEffects.SATURATION,6000,4,true,true,true),
                    1.0F)
            .statusEffect(
                    new StatusEffectInstance(StatusEffects.ABSORPTION,6000,4,true,true,true),
                    1.0F)
            .build()
            )
    ).group(ExampleMod.OTHER_GROUP));


    //构建一个猪符咒
    public static final FabricItem PIG_TOOL = new FabricItem(new FabricItemSettings().group(ExampleMod.OTHER_GROUP));

    //定义粒子类型
    //public static final  DefaultParticleType PIG_LASER = FabricParticleTypes.simple();



    //public static final FabricItem FABRIC_ITEM = new FabricItem(new FabricItemSettings().group(ExampleMod.ITEM_GROUP));

    //public static final FabricItem OTHER_ITEM2 = new FabricItem(new Item.Settings().food((new FoodComponent.Builder().hunger(20).build())));
    @Override
    //一个接口 Mod必须实现一个抽象方法
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        //打印日志信息
        LOGGER.info("Hello Fabric world!");
        //注册物品
        //这里注册了一个钻石苹果
        Registry.register(Registry.ITEM, new Identifier("first-fabric-mod", "fabric_item"), DIAMOND_APPLE);
        Registry.register(Registry.ITEM, new Identifier("first-fabric-mod","pig_tool"),PIG_TOOL);


        //注册别的包中的粒子类型  （可扩展性强）
        //调用其他类中的 注册方法
        ModParticles.registerParticles();


        //注册粒子类型 自定义的粒子
        //Registry.register(Registry.PARTICLE_TYPE, new Identifier("first-fabric-mod", "pig_laser"), PIG_LASER);

    }


}
