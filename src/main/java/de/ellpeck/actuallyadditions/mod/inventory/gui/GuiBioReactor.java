/*
 * This file ("GuiBioReactor.java") is part of the Actually Additions mod for Minecraft.
 * It is created and owned by Ellpeck and distributed
 * under the Actually Additions License to be found at
 * http://ellpeck.de/actaddlicense
 * View the source code at https://github.com/Ellpeck/ActuallyAdditions
 *
 * © 2015-2017 Ellpeck
 */

package de.ellpeck.actuallyadditions.mod.inventory.gui;

import de.ellpeck.actuallyadditions.mod.inventory.ContainerBioReactor;
import de.ellpeck.actuallyadditions.mod.tile.TileEntityBioReactor;
import de.ellpeck.actuallyadditions.mod.util.AssetUtil;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class GuiBioReactor extends GuiWtfMojang<ContainerBioReactor> {

    private static final ResourceLocation RES_LOC = AssetUtil.getGuiLocation("gui_bio_reactor");
    private final TileEntityBioReactor tile;
    private EnergyDisplay energy;

    public GuiBioReactor(ContainerBioReactor container, PlayerInventory inventory, ITextComponent title) {
        super(container, inventory);
        this.tile = container.tile;
        this.xSize = 176;
        this.ySize = 93 + 86;
    }

    @Override
    public void init() {
        super.init();
        this.energy = new EnergyDisplay(this.guiLeft + 116, this.guiTop + 5, this.tile.storage);
    }

    @Override
    public void drawScreen(int x, int y, float f) {
        super.drawScreen(x, y, f);
        this.energy.drawOverlay(x, y);
    }

    @Override
    public void drawGuiContainerForegroundLayer(int x, int y) {
        AssetUtil.displayNameString(this.font, this.xSize, -10, this.tile);
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float f, int x, int y) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        this.getMinecraft().getTextureManager().bindTexture(AssetUtil.GUI_INVENTORY_LOCATION);
        this.blit(matrices, this.guiLeft, this.guiTop + 93, 0, 0, 176, 86);

        this.getMinecraft().getTextureManager().bindTexture(RES_LOC);
        this.blit(matrices, this.guiLeft, this.guiTop, 0, 0, 176, 93);

        if (this.tile.burnTime > 0) {
            int i = this.tile.burnTime * 13 / this.tile.maxBurnTime;
            this.blit(matrices, this.guiLeft + 87, this.guiTop + 51 + 12 - i, 176, 96 - i, 14, i);
        }

        if (this.tile.producePerTick > 0) {
            this.drawCenteredString(this.font, this.tile.producePerTick + " " + I18n.format("actuallyadditions.cft"), this.guiLeft + 87, this.guiTop + 86, 0xFFFFFF);
        }

        this.energy.draw();
    }
}
