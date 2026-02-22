package org._1d6.ars_janky_me_source_jar_compat.mixin;

import java.util.List;

import org._1d6.ars_janky_me_source_jar_compat.MESourceJarAsSourceTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.hollingsworth.arsnouveau.api.source.ISpecialSourceProvider;
import com.hollingsworth.arsnouveau.api.source.SourceProvider;
import com.hollingsworth.arsnouveau.api.util.SourceUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import gripe._90.arseng.block.entity.MESourceJarBlockEntity;

@Mixin(value = SourceUtil.class, remap = false)
public class SourceUtilMixin {
    @Inject(method = "canGiveSource", at = @At("TAIL"))
    private static void canGiveSourceME(
            BlockPos pos, Level world, int range, CallbackInfoReturnable<List<ISpecialSourceProvider>> cir) {
        for (BlockPos b : BlockPos.withinManhattan(pos, range, range, range)) {
            if (world.isLoaded(b)
                    && world.getBlockEntity(b) instanceof MESourceJarBlockEntity jar
                    && jar.canAcceptSource(1))
                cir.getReturnValue().add(new SourceProvider(new MESourceJarAsSourceTile(jar), b.immutable()));
        }
    }

    @Inject(method = "canTakeSource", at = @At("TAIL"))
    private static void canTakeSourceME(
            BlockPos pos, Level world, int range, CallbackInfoReturnable<List<ISpecialSourceProvider>> cir) {
        for (BlockPos b : BlockPos.withinManhattan(pos, range, range, range)) {
            if (world.isLoaded(b)
                    && world.getBlockEntity(b) instanceof MESourceJarBlockEntity jar
                    && jar.canProvideSource(1))
                cir.getReturnValue().add(new SourceProvider(new MESourceJarAsSourceTile(jar), b.immutable()));
        }
    }
}
