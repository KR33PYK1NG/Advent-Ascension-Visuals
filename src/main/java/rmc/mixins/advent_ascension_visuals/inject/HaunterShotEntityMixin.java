package rmc.mixins.advent_ascension_visuals.inject;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.tslat.aoa3.entity.projectile.staff.HaunterShotEntity;

/**
 * Developed by RMC Team, 2021
 * @author KR33PY
 */
@Mixin(value = HaunterShotEntity.class)
public abstract class HaunterShotEntityMixin {

    private boolean rmc$skip;

    @Inject(method = "Lnet/tslat/aoa3/entity/projectile/staff/HaunterShotEntity;tick()V",
            cancellable = true,
            at = @At(value = "INVOKE",
                     target = "Lnet/tslat/aoa3/util/WorldUtil;createExplosion(Lnet/minecraft/entity/Entity;Lnet/minecraft/world/World;Lnet/minecraft/entity/Entity;F)Lnet/minecraft/world/Explosion;"))
    private void lowerExplosions(CallbackInfo mixin) {
        this.rmc$skip = !this.rmc$skip;
        if (this.rmc$skip) {
            mixin.cancel();
        }
    }

}