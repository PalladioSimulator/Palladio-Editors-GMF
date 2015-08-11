/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.usagemodel.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.palladiosimulator.pcm.core.provider.PalladioComponentModelEditPlugin;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;
import org.palladiosimulator.pcm.usagemodel.util.UsagemodelAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers. The
 * adapters generated by this factory convert EMF adapter notifications into calls to
 * {@link #fireNotifyChanged fireNotifyChanged}. The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class UsagemodelItemProviderAdapterFactory extends UsagemodelAdapterFactory
implements ComposeableAdapterFactory, IChangeNotifier, IDisposable, IChildCreationExtender {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2015 by palladiosimulator.org";

    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This helps manage the child creation extenders. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(
            PalladioComponentModelEditPlugin.INSTANCE, UsagemodelPackage.eNS_URI);

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType
     * isFactoryForType}. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<Object>();

    /**
     * This constructs an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public UsagemodelItemProviderAdapterFactory() {
        this.supportedTypes.add(IEditingDomainItemProvider.class);
        this.supportedTypes.add(IStructuredItemContentProvider.class);
        this.supportedTypes.add(ITreeItemContentProvider.class);
        this.supportedTypes.add(IItemLabelProvider.class);
        this.supportedTypes.add(IItemPropertySource.class);
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.palladiosimulator.pcm.usagemodel.UsageScenario} instances. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected UsageScenarioItemProvider usageScenarioItemProvider;

    /**
     * This creates an adapter for a {@link org.palladiosimulator.pcm.usagemodel.UsageScenario}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createUsageScenarioAdapter() {
        if (this.usageScenarioItemProvider == null)
        {
            this.usageScenarioItemProvider = new UsageScenarioItemProvider(this);
        }

        return this.usageScenarioItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.palladiosimulator.pcm.usagemodel.UserData} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected UserDataItemProvider userDataItemProvider;

    /**
     * This creates an adapter for a {@link org.palladiosimulator.pcm.usagemodel.UserData}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createUserDataAdapter() {
        if (this.userDataItemProvider == null)
        {
            this.userDataItemProvider = new UserDataItemProvider(this);
        }

        return this.userDataItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.palladiosimulator.pcm.usagemodel.UsageModel} instances. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected UsageModelItemProvider usageModelItemProvider;

    /**
     * This creates an adapter for a {@link org.palladiosimulator.pcm.usagemodel.UsageModel}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createUsageModelAdapter() {
        if (this.usageModelItemProvider == null)
        {
            this.usageModelItemProvider = new UsageModelItemProvider(this);
        }

        return this.usageModelItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall} instances. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected EntryLevelSystemCallItemProvider entryLevelSystemCallItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall}. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createEntryLevelSystemCallAdapter() {
        if (this.entryLevelSystemCallItemProvider == null)
        {
            this.entryLevelSystemCallItemProvider = new EntryLevelSystemCallItemProvider(this);
        }

        return this.entryLevelSystemCallItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour} instances. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ScenarioBehaviourItemProvider scenarioBehaviourItemProvider;

    /**
     * This creates an adapter for a {@link org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createScenarioBehaviourAdapter() {
        if (this.scenarioBehaviourItemProvider == null)
        {
            this.scenarioBehaviourItemProvider = new ScenarioBehaviourItemProvider(this);
        }

        return this.scenarioBehaviourItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.palladiosimulator.pcm.usagemodel.BranchTransition} instances. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected BranchTransitionItemProvider branchTransitionItemProvider;

    /**
     * This creates an adapter for a {@link org.palladiosimulator.pcm.usagemodel.BranchTransition}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createBranchTransitionAdapter() {
        if (this.branchTransitionItemProvider == null)
        {
            this.branchTransitionItemProvider = new BranchTransitionItemProvider(this);
        }

        return this.branchTransitionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.palladiosimulator.pcm.usagemodel.Branch} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected BranchItemProvider branchItemProvider;

    /**
     * This creates an adapter for a {@link org.palladiosimulator.pcm.usagemodel.Branch}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createBranchAdapter() {
        if (this.branchItemProvider == null)
        {
            this.branchItemProvider = new BranchItemProvider(this);
        }

        return this.branchItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.palladiosimulator.pcm.usagemodel.Loop} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected LoopItemProvider loopItemProvider;

    /**
     * This creates an adapter for a {@link org.palladiosimulator.pcm.usagemodel.Loop}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createLoopAdapter() {
        if (this.loopItemProvider == null)
        {
            this.loopItemProvider = new LoopItemProvider(this);
        }

        return this.loopItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.palladiosimulator.pcm.usagemodel.Stop} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected StopItemProvider stopItemProvider;

    /**
     * This creates an adapter for a {@link org.palladiosimulator.pcm.usagemodel.Stop}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createStopAdapter() {
        if (this.stopItemProvider == null)
        {
            this.stopItemProvider = new StopItemProvider(this);
        }

        return this.stopItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.palladiosimulator.pcm.usagemodel.Start} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected StartItemProvider startItemProvider;

    /**
     * This creates an adapter for a {@link org.palladiosimulator.pcm.usagemodel.Start}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createStartAdapter() {
        if (this.startItemProvider == null)
        {
            this.startItemProvider = new StartItemProvider(this);
        }

        return this.startItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.palladiosimulator.pcm.usagemodel.OpenWorkload} instances. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected OpenWorkloadItemProvider openWorkloadItemProvider;

    /**
     * This creates an adapter for a {@link org.palladiosimulator.pcm.usagemodel.OpenWorkload}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createOpenWorkloadAdapter() {
        if (this.openWorkloadItemProvider == null)
        {
            this.openWorkloadItemProvider = new OpenWorkloadItemProvider(this);
        }

        return this.openWorkloadItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.palladiosimulator.pcm.usagemodel.Delay} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected DelayItemProvider delayItemProvider;

    /**
     * This creates an adapter for a {@link org.palladiosimulator.pcm.usagemodel.Delay}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createDelayAdapter() {
        if (this.delayItemProvider == null)
        {
            this.delayItemProvider = new DelayItemProvider(this);
        }

        return this.delayItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.palladiosimulator.pcm.usagemodel.ClosedWorkload} instances. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ClosedWorkloadItemProvider closedWorkloadItemProvider;

    /**
     * This creates an adapter for a {@link org.palladiosimulator.pcm.usagemodel.ClosedWorkload}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createClosedWorkloadAdapter() {
        if (this.closedWorkloadItemProvider == null)
        {
            this.closedWorkloadItemProvider = new ClosedWorkloadItemProvider(this);
        }

        return this.closedWorkloadItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ComposeableAdapterFactory getRootAdapterFactory() {
        return this.parentAdapterFactory == null ? this : this.parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setParentAdapterFactory(final ComposedAdapterFactory parentAdapterFactory) {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isFactoryForType(final Object type) {
        return this.supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the adapter. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter adapt(final Notifier notifier, final Object type) {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object adapt(final Object object, final Object type) {
        if (this.isFactoryForType(type))
        {
            final Object adapter = super.adapt(object, type);
            if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter)))
            {
                return adapter;
            }
        }

        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public List<IChildCreationExtender> getChildCreationExtenders() {
        return this.childCreationExtenderManager.getChildCreationExtenders();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Collection<?> getNewChildDescriptors(final Object object, final EditingDomain editingDomain) {
        return this.childCreationExtenderManager.getNewChildDescriptors(object, editingDomain);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return this.childCreationExtenderManager;
    }

    /**
     * This adds a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void addListener(final INotifyChangedListener notifyChangedListener) {
        this.changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void removeListener(final INotifyChangedListener notifyChangedListener) {
        this.changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void fireNotifyChanged(final Notification notification) {
        this.changeNotifier.fireNotifyChanged(notification);

        if (this.parentAdapterFactory != null)
        {
            this.parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void dispose() {
        if (this.usageScenarioItemProvider != null) {
            this.usageScenarioItemProvider.dispose();
        }
        if (this.userDataItemProvider != null) {
            this.userDataItemProvider.dispose();
        }
        if (this.usageModelItemProvider != null) {
            this.usageModelItemProvider.dispose();
        }
        if (this.entryLevelSystemCallItemProvider != null) {
            this.entryLevelSystemCallItemProvider.dispose();
        }
        if (this.scenarioBehaviourItemProvider != null) {
            this.scenarioBehaviourItemProvider.dispose();
        }
        if (this.branchTransitionItemProvider != null) {
            this.branchTransitionItemProvider.dispose();
        }
        if (this.branchItemProvider != null) {
            this.branchItemProvider.dispose();
        }
        if (this.loopItemProvider != null) {
            this.loopItemProvider.dispose();
        }
        if (this.stopItemProvider != null) {
            this.stopItemProvider.dispose();
        }
        if (this.startItemProvider != null) {
            this.startItemProvider.dispose();
        }
        if (this.openWorkloadItemProvider != null) {
            this.openWorkloadItemProvider.dispose();
        }
        if (this.delayItemProvider != null) {
            this.delayItemProvider.dispose();
        }
        if (this.closedWorkloadItemProvider != null) {
            this.closedWorkloadItemProvider.dispose();
        }
    }

}
