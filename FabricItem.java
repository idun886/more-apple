package net.fabricmc.example;

import net.fabricmc.example.particle.ModParticles;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.CsvWriter;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FabricItem extends Item {

    public FabricItem(Settings settrings){
        super(settrings);
    }

    @Override
    //这个方法可以让创造的物品右键发出声音
    //键盘的操作结果类 <物品堆栈> use (世界 世界 ，玩家实体 玩家实体 ，手 手)
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){
        //玩家实体.播放声音（声音事件.块状羊毛被破坏的声音  1.0F体积  1.0F 沥青）
        playerEntity.playSound(SoundEvents.BLOCK_CAKE_ADD_CANDLE,1.0F,1.0F);

        world.addParticle(ModParticles.PIG_LASER,playerEntity.getX(),playerEntity.getY(),playerEntity.getZ()+10,10,10,10);
        System.out.println("=======================");
        //水平角度 （水平方向的360度）  偏航角
        System.out.println("player's yaw:"+playerEntity.getYaw());
        //垂直角度（垂直方向的360度)  俯仰角
        System.out.println("player's pitch:"+playerEntity.getPitch());
        //玩家朝向（东南西北）
        System.out.println("player direction:"+playerEntity.getMovementDirection());
        System.out.println("=======================");
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
        //这是规定行动的方法  playerEntity.xxxxx


    }


}
