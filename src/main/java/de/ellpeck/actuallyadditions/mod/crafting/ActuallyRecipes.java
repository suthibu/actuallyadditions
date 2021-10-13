package de.ellpeck.actuallyadditions.mod.crafting;

import de.ellpeck.actuallyadditions.mod.ActuallyAdditions;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ActuallyRecipes {
    public static final DeferredRegister<IRecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ActuallyAdditions.MODID);

    public static void init(IEventBus bus) {
        SERIALIZERS.register(bus);
    }

    public static final RegistryObject<IRecipeSerializer<?>> KEEP_DATA_SHAPED_RECIPE = SERIALIZERS.register(RecipeKeepDataShaped.NAME, RecipeKeepDataShaped.Serializer::new);
    public static final RegistryObject<IRecipeSerializer<?>> LASER_RECIPE = SERIALIZERS.register(LaserRecipe.NAME, LaserRecipe.Serializer::new);



    public static class Types {
        public static final IRecipeType<LaserRecipe> LASER = IRecipeType.register(ActuallyAdditions.MODID + ":laser");
        //public static final IRecipeType<EmpoweringRecipe> EMPOWERING = IRecipeType.register(ActuallyAdditions.MODID + ":empower");
        //public static final IRecipeType<CrushingRecipe> CRUSHING = IRecipeType.register(ActuallyAdditions.MODID + ":crush");
        //public static final IRecipeType<SolidFuelRecipe> SOLIDFUEL = IRecipeType.register(ActuallyAdditions.MODID + ":solid_fuel");
        //public static final IRecipeType<LiquidFuelRecipe> LIQUIDFUEL = IRecipeType.register(ActuallyAdditions.MODID + ":liquid_fuel");
    }
}
