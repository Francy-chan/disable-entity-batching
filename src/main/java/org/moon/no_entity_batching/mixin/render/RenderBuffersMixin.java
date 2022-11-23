package org.moon.no_entity_batching.mixin.render;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.OutlineBufferSource;
import net.minecraft.client.renderer.RenderBuffers;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = RenderBuffers.class, priority = 1)
public class RenderBuffersMixin {

    @Shadow @Final private MultiBufferSource.BufferSource bufferSource;
    @Shadow @Final private MultiBufferSource.BufferSource crumblingBufferSource;
    @Shadow @Final private OutlineBufferSource outlineBufferSource;

    @Inject(method = "bufferSource", at = @At("HEAD"), cancellable = true)
    private void vanillaBufferSource(CallbackInfoReturnable<MultiBufferSource.BufferSource> cir) {
        cir.setReturnValue(this.bufferSource);
    }

    @Inject(method = "crumblingBufferSource", at = @At("HEAD"), cancellable = true)
    private void vanillaCrumblingBufferSource(CallbackInfoReturnable<MultiBufferSource.BufferSource> cir) {
        cir.setReturnValue(this.crumblingBufferSource);
    }

    @Inject(method = "outlineBufferSource", at = @At("HEAD"), cancellable = true)
    private void vanillaOutlineBufferSource(CallbackInfoReturnable<OutlineBufferSource> cir) {
        cir.setReturnValue(this.outlineBufferSource);
    }
}
