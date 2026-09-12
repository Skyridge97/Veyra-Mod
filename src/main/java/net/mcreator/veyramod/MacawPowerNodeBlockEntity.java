package net.mcreator.veyramod.blockentity;

import net.mcreator.veyramod.registry.ModBlockEntities;
import com.mrcrayfish.furniture.refurbished.electricity.Connection;
import com.mrcrayfish.furniture.refurbished.electricity.IElectricityNode;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;

import java.util.HashSet;
import java.util.Set;

public class MacawPowerNodeBlockEntity extends BlockEntity implements IElectricityNode {

    private boolean powered = false;
    private boolean receivingPower = false;
    private final Set<Connection> connections = new HashSet<>();
    private final Set<BlockPos> powerSources = new HashSet<>();

    public MacawPowerNodeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MACAW_POWER_NODE.get(), pos, state);
    }

    @Override
    public BlockPos getNodePosition() {
        return this.worldPosition;
    }

    @Override
    public Level getNodeLevel() {
        return this.level;
    }

    @Override
    public BlockEntity getNodeOwner() {
        return this;
    }

    @Override
    public AABB getNodeInteractBox() {
        return new AABB(0.375, 0.375, 0.375, 0.625, 0.625, 0.625);
    }

    @Override
    public boolean isSourceNode() {
        return false;
    }

    @Override
    public boolean isNodePowered() {
        return this.powered;
    }

    @Override
    public void setNodePowered(boolean powered) {
        this.powered = powered;
        if (this.level != null && !this.level.isClientSide) {
            BlockState state = this.getBlockState();
            if (state.hasProperty(BlockStateProperties.LIT)) {
                this.level.setBlock(this.worldPosition, state.setValue(BlockStateProperties.LIT, powered), 3);
            }
            this.setChanged();
            this.syncDataToTrackingClients();
        }
    }

    @Override
    public Set<Connection> getNodeConnections() {
        return this.connections;
    }

    @Override
    public void setNodeReceivingPower(boolean state) {
        this.receivingPower = state;
    }

    @Override
    public boolean isNodeReceivingPower() {
        return this.receivingPower;
    }

    @Override
    public Set<BlockPos> getPowerSources() {
        return this.powerSources;
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putBoolean("Powered", this.powered);
        // connections are handled by the interface default writeNodeNbt if you call it
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.powered = tag.getBoolean("Powered");
    }
}