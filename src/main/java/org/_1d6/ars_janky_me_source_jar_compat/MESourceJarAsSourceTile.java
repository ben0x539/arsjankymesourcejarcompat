package org._1d6.ars_janky_me_source_jar_compat;

import com.hollingsworth.arsnouveau.api.source.ISourceTile;

import gripe._90.arseng.block.entity.MESourceJarBlockEntity;

public class MESourceJarAsSourceTile implements ISourceTile {
    final MESourceJarBlockEntity jar;

    public MESourceJarAsSourceTile(MESourceJarBlockEntity j) {
        jar = j;
    }

    @Override
    public int getTransferRate() {
        return jar.getSourceCapacity();
    }

    @Override
    public boolean canAcceptSource() {
        return jar.canAcceptSource(1);
    }

    @Override
    public boolean canProvideSource() {
        return jar.canProvideSource(1);
    }

    @Override
    public int getSource() {
        return jar.getSource();
    }

    @Override
    public int getMaxSource() {
        return jar.getMaxSource();
    }

    @Override
    public int setSource(int source) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int addSource(int source, boolean simulate) {
        return jar.receiveSource(source, simulate);
    }

    @Override
    public int addSource(int source) {
        return jar.receiveSource(source, false);
    }

    @Override
    public int removeSource(int source, boolean simulate) {
        return jar.extractSource(source, simulate);
    }

    @Override
    public int removeSource(int source) {
        return jar.extractSource(source, false);
    }
}
