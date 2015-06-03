/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation.presentation;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.common.ui.editor.ProblemEditorPart;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.palladiosimulator.mdsdprofiles.provider.StereotypableElementDecoratorAdapterFactory;

import de.uka.ipd.sdq.identifier.provider.IdentifierItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.allocation.provider.AllocationItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.core.composition.provider.CompositionItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.core.entity.provider.EntityItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.core.presentation.PalladioComponentModelEditorPlugin;
import de.uka.ipd.sdq.pcm.core.provider.CoreItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.parameter.provider.ParameterItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.protocol.provider.ProtocolItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.qosannotations.provider.QosannotationsItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.provider.QosPerformanceItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.reliability.provider.ReliabilityItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.resourceenvironment.provider.ResourceenvironmentItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.resourcetype.provider.ResourcetypeItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.seff.provider.SeffItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.seff.seff_performance.provider.SeffPerformanceItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.subsystem.provider.SubsystemItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.system.provider.SystemItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.usagemodel.provider.UsagemodelItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;
import de.uka.ipd.sdq.probfunction.provider.ProbfunctionItemProviderAdapterFactory;
import de.uka.ipd.sdq.stoex.provider.StoexItemProviderAdapterFactory;
import de.uka.ipd.sdq.units.provider.UnitsItemProviderAdapterFactory;

/**
 * @generated
 */
public class AllocationEditor extends MultiPageEditorPart implements IEditingDomainProvider, ISelectionProvider,
        IMenuListener, IViewerProvider, IGotoMarker {

    /**
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * @generated
     */
    protected AdapterFactoryEditingDomain editingDomain;

    /**
     * This is the one adapter factory used for providing views of the model. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated not
     */
    protected AdapterFactory adapterFactory;

    /**
     * @generated
     */
    protected IContentOutlinePage contentOutlinePage;

    /**
     * @generated
     */
    protected IStatusLineManager contentOutlineStatusLineManager;

    /**
     * @generated
     */
    protected TreeViewer contentOutlineViewer;

    /**
     * This is the property sheet page. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected List<PropertySheetPage> propertySheetPages = new ArrayList<PropertySheetPage>();

    /**
     * @generated
     */
    protected TreeViewer selectionViewer;

    /**
     * @generated
     */
    protected TreeViewer parentViewer;

    /**
     * @generated
     */
    protected TreeViewer treeViewer;

    /**
     * @generated
     */
    protected ListViewer listViewer;

    /**
     * @generated
     */
    protected TableViewer tableViewer;

    /**
     * @generated
     */
    protected TreeViewer treeViewerWithColumns;

    /**
     * @generated
     */
    protected ViewerPane currentViewerPane;

    /**
     * @generated
     */
    protected Viewer currentViewer;

    /**
     * @generated
     */
    protected ISelectionChangedListener selectionChangedListener;

    /**
     * @generated
     */
    protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();

    /**
     * @generated
     */
    protected ISelection editorSelection = StructuredSelection.EMPTY;

    /**
     * @generated
     */
    protected MarkerHelper markerHelper = new EditUIMarkerHelper();

    /**
     * @generated
     */
    protected IPartListener partListener = new IPartListener() {

        @Override
        public void partActivated(final IWorkbenchPart p) {
            if (p instanceof ContentOutline) {
                if (((ContentOutline) p).getCurrentPage() == AllocationEditor.this.contentOutlinePage) {
                    getActionBarContributor().setActiveEditor(AllocationEditor.this);

                    setCurrentViewer(AllocationEditor.this.contentOutlineViewer);
                }
            } else if (p instanceof PropertySheet) {
                if (AllocationEditor.this.propertySheetPages.contains(((PropertySheet) p).getCurrentPage())) {
                    getActionBarContributor().setActiveEditor(AllocationEditor.this);
                    handleActivate();
                }
            } else if (p == AllocationEditor.this) {
                handleActivate();
            }
        }

        @Override
        public void partBroughtToTop(final IWorkbenchPart p) {
            // Ignore.
        }

        @Override
        public void partClosed(final IWorkbenchPart p) {
            // Ignore.
        }

        @Override
        public void partDeactivated(final IWorkbenchPart p) {
            // Ignore.
        }

        @Override
        public void partOpened(final IWorkbenchPart p) {
            // Ignore.
        }
    };

    /**
     * @generated
     */
    protected Collection<Resource> removedResources = new ArrayList<Resource>();

    /**
     * @generated
     */
    protected Collection<Resource> changedResources = new ArrayList<Resource>();

    /**
     * @generated
     */
    protected Collection<Resource> savedResources = new ArrayList<Resource>();

    /**
     * @generated
     */
    protected Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();

    /**
     * @generated
     */
    protected boolean updateProblemIndication = true;

    /**
     * @generated
     */
    protected EContentAdapter problemIndicationAdapter = new EContentAdapter() {

        @Override
        public void notifyChanged(final Notification notification) {
            if (notification.getNotifier() instanceof Resource) {
                switch (notification.getFeatureID(Resource.class)) {
                case Resource.RESOURCE__IS_LOADED:
                case Resource.RESOURCE__ERRORS:
                case Resource.RESOURCE__WARNINGS: {
                    final Resource resource = (Resource) notification.getNotifier();
                    final Diagnostic diagnostic = analyzeResourceProblems(resource, null);
                    if (diagnostic.getSeverity() != Diagnostic.OK) {
                        AllocationEditor.this.resourceToDiagnosticMap.put(resource, diagnostic);
                    } else {
                        AllocationEditor.this.resourceToDiagnosticMap.remove(resource);
                    }

                    if (AllocationEditor.this.updateProblemIndication) {
                        getSite().getShell().getDisplay().asyncExec(new Runnable() {

                            @Override
                            public void run() {
                                updateProblemIndication();
                            }
                        });
                    }
                    break;
                }
                }
            } else {
                super.notifyChanged(notification);
            }
        }

        @Override
        protected void setTarget(final Resource target) {
            basicSetTarget(target);
        }

        @Override
        protected void unsetTarget(final Resource target) {
            basicUnsetTarget(target);
            AllocationEditor.this.resourceToDiagnosticMap.remove(target);
            if (AllocationEditor.this.updateProblemIndication) {
                getSite().getShell().getDisplay().asyncExec(new Runnable() {

                    @Override
                    public void run() {
                        updateProblemIndication();
                    }
                });
            }
        }
    };

    /**
     * @generated
     */
    protected IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {

        @Override
        public void resourceChanged(final IResourceChangeEvent event) {
            final IResourceDelta delta = event.getDelta();
            try {
                class ResourceDeltaVisitor implements IResourceDeltaVisitor {

                    protected ResourceSet resourceSet = AllocationEditor.this.editingDomain.getResourceSet();
                    protected Collection<Resource> changedResources = new ArrayList<Resource>();
                    protected Collection<Resource> removedResources = new ArrayList<Resource>();

                    @Override
                    public boolean visit(final IResourceDelta delta) {
                        if (delta.getResource().getType() == IResource.FILE) {
                            if (delta.getKind() == IResourceDelta.REMOVED || delta.getKind() == IResourceDelta.CHANGED
                                    && delta.getFlags() != IResourceDelta.MARKERS) {
                                final Resource resource = this.resourceSet.getResource(
                                        URI.createPlatformResourceURI(delta.getFullPath().toString(), true), false);
                                if (resource != null) {
                                    if (delta.getKind() == IResourceDelta.REMOVED) {
                                        this.removedResources.add(resource);
                                    } else if (!AllocationEditor.this.savedResources.remove(resource)) {
                                        this.changedResources.add(resource);
                                    }
                                }
                            }
                            return false;
                        }

                        return true;
                    }

                    public Collection<Resource> getChangedResources() {
                        return this.changedResources;
                    }

                    public Collection<Resource> getRemovedResources() {
                        return this.removedResources;
                    }
                }

                final ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
                delta.accept(visitor);

                if (!visitor.getRemovedResources().isEmpty()) {
                    getSite().getShell().getDisplay().asyncExec(new Runnable() {

                        @Override
                        public void run() {
                            AllocationEditor.this.removedResources.addAll(visitor.getRemovedResources());
                            if (!isDirty()) {
                                getSite().getPage().closeEditor(AllocationEditor.this, false);
                            }
                        }
                    });
                }

                if (!visitor.getChangedResources().isEmpty()) {
                    getSite().getShell().getDisplay().asyncExec(new Runnable() {

                        @Override
                        public void run() {
                            AllocationEditor.this.changedResources.addAll(visitor.getChangedResources());
                            if (getSite().getPage().getActiveEditor() == AllocationEditor.this) {
                                handleActivate();
                            }
                        }
                    });
                }
            } catch (final CoreException exception) {
                PalladioComponentModelEditorPlugin.INSTANCE.log(exception);
            }
        }
    };

    /**
     * @generated
     */
    protected void handleActivate() {
        // Recompute the read only state.
        //
        if (this.editingDomain.getResourceToReadOnlyMap() != null) {
            this.editingDomain.getResourceToReadOnlyMap().clear();

            // Refresh any actions that may become enabled or disabled.
            //
            setSelection(getSelection());
        }

        if (!this.removedResources.isEmpty()) {
            if (handleDirtyConflict()) {
                getSite().getPage().closeEditor(AllocationEditor.this, false);
            } else {
                this.removedResources.clear();
                this.changedResources.clear();
                this.savedResources.clear();
            }
        } else if (!this.changedResources.isEmpty()) {
            this.changedResources.removeAll(this.savedResources);
            handleChangedResources();
            this.changedResources.clear();
            this.savedResources.clear();
        }
    }

    /**
     * @generated
     */
    protected void handleChangedResources() {
        if (!this.changedResources.isEmpty() && (!isDirty() || handleDirtyConflict())) {
            if (isDirty()) {
                this.changedResources.addAll(this.editingDomain.getResourceSet().getResources());
            }
            this.editingDomain.getCommandStack().flush();

            this.updateProblemIndication = false;
            for (final Resource resource : this.changedResources) {
                if (resource.isLoaded()) {
                    resource.unload();
                    try {
                        resource.load(Collections.EMPTY_MAP);
                    } catch (final IOException exception) {
                        if (!this.resourceToDiagnosticMap.containsKey(resource)) {
                            this.resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
                        }
                    }
                }
            }

            if (AdapterFactoryEditingDomain.isStale(this.editorSelection)) {
                setSelection(StructuredSelection.EMPTY);
            }

            this.updateProblemIndication = true;
            updateProblemIndication();
        }
    }

    /**
     * @generated
     */
    protected void updateProblemIndication() {
        if (this.updateProblemIndication) {
            final BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.OK, "de.uka.ipd.sdq.pcm.editor", 0, null,
                    new Object[] { this.editingDomain.getResourceSet() });
            for (final Diagnostic childDiagnostic : this.resourceToDiagnosticMap.values()) {
                if (childDiagnostic.getSeverity() != Diagnostic.OK) {
                    diagnostic.add(childDiagnostic);
                }
            }

            int lastEditorPage = getPageCount() - 1;
            if (lastEditorPage >= 0 && getEditor(lastEditorPage) instanceof ProblemEditorPart) {
                ((ProblemEditorPart) getEditor(lastEditorPage)).setDiagnostic(diagnostic);
                if (diagnostic.getSeverity() != Diagnostic.OK) {
                    setActivePage(lastEditorPage);
                }
            } else if (diagnostic.getSeverity() != Diagnostic.OK) {
                final ProblemEditorPart problemEditorPart = new ProblemEditorPart();
                problemEditorPart.setDiagnostic(diagnostic);
                problemEditorPart.setMarkerHelper(this.markerHelper);
                try {
                    addPage(++lastEditorPage, problemEditorPart, getEditorInput());
                    setPageText(lastEditorPage, problemEditorPart.getPartName());
                    setActivePage(lastEditorPage);
                    showTabs();
                } catch (final PartInitException exception) {
                    PalladioComponentModelEditorPlugin.INSTANCE.log(exception);
                }
            }

            if (this.markerHelper.hasMarkers(this.editingDomain.getResourceSet())) {
                this.markerHelper.deleteMarkers(this.editingDomain.getResourceSet());
                if (diagnostic.getSeverity() != Diagnostic.OK) {
                    try {
                        this.markerHelper.createMarkers(diagnostic);
                    } catch (final CoreException exception) {
                        PalladioComponentModelEditorPlugin.INSTANCE.log(exception);
                    }
                }
            }
        }
    }

    /**
     * @generated
     */
    protected boolean handleDirtyConflict() {
        return MessageDialog.openQuestion(getSite().getShell(), getString("_UI_FileConflict_label"),
                getString("_WARN_FileConflict"));
    }

    /**
     * @generated
     */
    public AllocationEditor() {
        super();
        initializeEditingDomain();
    }

    /**
     * This sets up the editing domain for the model editor. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated not
     */
    protected void initializeEditingDomain() {
        // Create an adapter factory that yields item providers.
        //
        final ComposedAdapterFactory compAdapterFactory = new ComposedAdapterFactory(
                ComposedAdapterFactory.Descriptor.Registry.INSTANCE) {

            @Override
            public ComposeableAdapterFactory getRootAdapterFactory() {
                return (ComposeableAdapterFactory) AllocationEditor.this.adapterFactory;
            }
        };

        compAdapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new CoreItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new EntityItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new CompositionItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new ProtocolItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new SubsystemItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new ParameterItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new SeffItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new SeffPerformanceItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new AllocationItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new ResourceenvironmentItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new ResourcetypeItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new SystemItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new QosannotationsItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new QosPerformanceItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new ReliabilityItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new UsagemodelItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new IdentifierItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new StoexItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new UnitsItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new ProbfunctionItemProviderAdapterFactory());
        compAdapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

        this.adapterFactory = new StereotypableElementDecoratorAdapterFactory(new PalladioItemProviderAdapterFactory(
                compAdapterFactory));

        // Create the command stack that will notify this editor as commands are executed.
        //
        final BasicCommandStack commandStack = new BasicCommandStack();

        // Add a listener to set the most recent command's affected objects to be the selection of
        // the viewer with focus.
        //
        commandStack.addCommandStackListener(new CommandStackListener() {

            @Override
            public void commandStackChanged(final EventObject event) {
                AllocationEditor.this.getContainer().getDisplay().asyncExec(new Runnable() {

                    @Override
                    public void run() {
                        AllocationEditor.this.firePropertyChange(IEditorPart.PROP_DIRTY);

                        // Try to select the affected objects.
                        //
                        final Command mostRecentCommand = ((CommandStack) event.getSource()).getMostRecentCommand();
                        if (mostRecentCommand != null) {
                            AllocationEditor.this.setSelectionToViewer(mostRecentCommand.getAffectedObjects());
                        }

                        for (final PropertySheetPage propertySheetPage : AllocationEditor.this.propertySheetPages) {
                            if (!propertySheetPage.getControl().isDisposed()) {
                                propertySheetPage.refresh();
                            }

                        }

                    }
                });
            }
        });

        // Create the editing domain with a special command stack.
        //
        this.editingDomain = new AdapterFactoryEditingDomain(this.adapterFactory, commandStack,
                new HashMap<Resource, Boolean>());
    }

    /**
     * @generated
     */
    @Override
    protected void firePropertyChange(final int action) {
        super.firePropertyChange(action);
    }

    /**
     * @generated
     */
    public void setSelectionToViewer(final Collection<?> collection) {
        final Collection<?> theSelection = collection;
        // Make sure it's okay.
        //
        if (theSelection != null && !theSelection.isEmpty()) {
            final Runnable runnable = new Runnable() {

                @Override
                public void run() {
                    // Try to select the items in the current content viewer of the editor.
                    //
                    if (AllocationEditor.this.currentViewer != null) {
                        AllocationEditor.this.currentViewer.setSelection(
                                new StructuredSelection(theSelection.toArray()), true);
                    }
                }
            };
            getSite().getShell().getDisplay().asyncExec(runnable);
        }
    }

    /**
     * @generated
     */
    @Override
    public EditingDomain getEditingDomain() {
        return this.editingDomain;
    }

    /**
     * @generated
     */
    public class ReverseAdapterFactoryContentProvider extends AdapterFactoryContentProvider {

        /**
         * @generated
         */
        public ReverseAdapterFactoryContentProvider(final AdapterFactory adapterFactory) {
            super(adapterFactory);
        }

        /**
         * @generated
         */
        @Override
        public Object[] getElements(final Object object) {
            final Object parent = super.getParent(object);
            return (parent == null ? Collections.EMPTY_SET : Collections.singleton(parent)).toArray();
        }

        /**
         * @generated
         */
        @Override
        public Object[] getChildren(final Object object) {
            final Object parent = super.getParent(object);
            return (parent == null ? Collections.EMPTY_SET : Collections.singleton(parent)).toArray();
        }

        /**
         * @generated
         */
        @Override
        public boolean hasChildren(final Object object) {
            final Object parent = super.getParent(object);
            return parent != null;
        }

        /**
         * @generated
         */
        @Override
        public Object getParent(final Object object) {
            return null;
        }
    }

    /**
     * @generated
     */
    public void setCurrentViewerPane(final ViewerPane viewerPane) {
        if (this.currentViewerPane != viewerPane) {
            if (this.currentViewerPane != null) {
                this.currentViewerPane.showFocus(false);
            }
            this.currentViewerPane = viewerPane;
        }
        setCurrentViewer(this.currentViewerPane.getViewer());
    }

    /**
     * @generated
     */
    public void setCurrentViewer(final Viewer viewer) {
        // If it is changing...
        //
        if (this.currentViewer != viewer) {
            if (this.selectionChangedListener == null) {
                // Create the listener on demand.
                //
                this.selectionChangedListener = new ISelectionChangedListener() {

                    // This just notifies those things that are affected by the section.
                    //
                    @Override
                    public void selectionChanged(final SelectionChangedEvent selectionChangedEvent) {
                        setSelection(selectionChangedEvent.getSelection());
                    }
                };
            }

            // Stop listening to the old one.
            //
            if (this.currentViewer != null) {
                this.currentViewer.removeSelectionChangedListener(this.selectionChangedListener);
            }

            // Start listening to the new one.
            //
            if (viewer != null) {
                viewer.addSelectionChangedListener(this.selectionChangedListener);
            }

            // Remember it.
            //
            this.currentViewer = viewer;

            // Set the editors selection based on the current viewer's selection.
            //
            setSelection(this.currentViewer == null ? StructuredSelection.EMPTY : this.currentViewer.getSelection());
        }
    }

    /**
     * @generated
     */
    @Override
    public Viewer getViewer() {
        return this.currentViewer;
    }

    /**
     * @generated
     */
    protected void createContextMenuFor(final StructuredViewer viewer) {
        final MenuManager contextMenu = new MenuManager("#PopUp");
        contextMenu.add(new Separator("additions"));
        contextMenu.setRemoveAllWhenShown(true);
        contextMenu.addMenuListener(this);
        final Menu menu = contextMenu.createContextMenu(viewer.getControl());
        viewer.getControl().setMenu(menu);
        getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));

        final int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
        final Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
        viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
        viewer.addDropSupport(dndOperations, transfers, new EditingDomainViewerDropAdapter(this.editingDomain, viewer));
    }

    /**
     * @generated
     */
    public void createModel() {
        final URI resourceURI = EditUIUtil.getURI(getEditorInput());
        Exception exception = null;
        Resource resource = null;
        try {
            // Load the resource through the editing domain.
            //
            resource = this.editingDomain.getResourceSet().getResource(resourceURI, true);
        } catch (final Exception e) {
            exception = e;
            resource = this.editingDomain.getResourceSet().getResource(resourceURI, false);
        }

        final Diagnostic diagnostic = analyzeResourceProblems(resource, exception);
        if (diagnostic.getSeverity() != Diagnostic.OK) {
            this.resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
        }
        this.editingDomain.getResourceSet().eAdapters().add(this.problemIndicationAdapter);
    }

    /**
     * @generated
     */
    public Diagnostic analyzeResourceProblems(final Resource resource, final Exception exception) {
        if (!resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty()) {
            final BasicDiagnostic basicDiagnostic = new BasicDiagnostic(Diagnostic.ERROR, "de.uka.ipd.sdq.pcm.editor",
                    0, getString("_UI_CreateModelError_message", resource.getURI()),
                    new Object[] { exception == null ? (Object) resource : exception });
            basicDiagnostic.merge(EcoreUtil.computeDiagnostic(resource, true));
            return basicDiagnostic;
        } else if (exception != null) {
            return new BasicDiagnostic(Diagnostic.ERROR, "de.uka.ipd.sdq.pcm.editor", 0, getString(
                    "_UI_CreateModelError_message", resource.getURI()), new Object[] { exception });
        } else {
            return Diagnostic.OK_INSTANCE;
        }
    }

    /**
     * @generated
     */
    @Override
    public void createPages() {
        // Creates the model from the editor input
        //
        createModel();

        // Only creates the other pages if there is something that can be edited
        //
        if (!getEditingDomain().getResourceSet().getResources().isEmpty()) {
            // Create a page for the selection tree view.
            //
            {
                final ViewerPane viewerPane = new ViewerPane(getSite().getPage(), AllocationEditor.this) {

                    @Override
                    public Viewer createViewer(final Composite composite) {
                        final Tree tree = new Tree(composite, SWT.MULTI);
                        final TreeViewer newTreeViewer = new TreeViewer(tree);
                        return newTreeViewer;
                    }

                    @Override
                    public void requestActivation() {
                        super.requestActivation();
                        setCurrentViewerPane(this);
                    }
                };
                viewerPane.createControl(getContainer());

                this.selectionViewer = (TreeViewer) viewerPane.getViewer();
                this.selectionViewer.setContentProvider(new AdapterFactoryContentProvider(this.adapterFactory));

                this.selectionViewer.setLabelProvider(new AdapterFactoryLabelProvider(this.adapterFactory));
                this.selectionViewer.setInput(this.editingDomain.getResourceSet());
                this.selectionViewer.setSelection(new StructuredSelection(this.editingDomain.getResourceSet()
                        .getResources().get(0)), true);
                viewerPane.setTitle(this.editingDomain.getResourceSet());

                new AdapterFactoryTreeEditor(this.selectionViewer.getTree(), this.adapterFactory);

                createContextMenuFor(this.selectionViewer);
                final int pageIndex = addPage(viewerPane.getControl());
                setPageText(pageIndex, getString("_UI_SelectionPage_label"));
            }

            // Create a page for the parent tree view.
            //
            {
                final ViewerPane viewerPane = new ViewerPane(getSite().getPage(), AllocationEditor.this) {

                    @Override
                    public Viewer createViewer(final Composite composite) {
                        final Tree tree = new Tree(composite, SWT.MULTI);
                        final TreeViewer newTreeViewer = new TreeViewer(tree);
                        return newTreeViewer;
                    }

                    @Override
                    public void requestActivation() {
                        super.requestActivation();
                        setCurrentViewerPane(this);
                    }
                };
                viewerPane.createControl(getContainer());

                this.parentViewer = (TreeViewer) viewerPane.getViewer();
                this.parentViewer.setAutoExpandLevel(30);
                this.parentViewer.setContentProvider(new ReverseAdapterFactoryContentProvider(this.adapterFactory));
                this.parentViewer.setLabelProvider(new AdapterFactoryLabelProvider(this.adapterFactory));

                createContextMenuFor(this.parentViewer);
                final int pageIndex = addPage(viewerPane.getControl());
                setPageText(pageIndex, getString("_UI_ParentPage_label"));
            }

            // This is the page for the list viewer
            //
            {
                final ViewerPane viewerPane = new ViewerPane(getSite().getPage(), AllocationEditor.this) {

                    @Override
                    public Viewer createViewer(final Composite composite) {
                        return new ListViewer(composite);
                    }

                    @Override
                    public void requestActivation() {
                        super.requestActivation();
                        setCurrentViewerPane(this);
                    }
                };
                viewerPane.createControl(getContainer());
                this.listViewer = (ListViewer) viewerPane.getViewer();
                this.listViewer.setContentProvider(new AdapterFactoryContentProvider(this.adapterFactory));
                this.listViewer.setLabelProvider(new AdapterFactoryLabelProvider(this.adapterFactory));

                createContextMenuFor(this.listViewer);
                final int pageIndex = addPage(viewerPane.getControl());
                setPageText(pageIndex, getString("_UI_ListPage_label"));
            }

            // This is the page for the tree viewer
            //
            {
                final ViewerPane viewerPane = new ViewerPane(getSite().getPage(), AllocationEditor.this) {

                    @Override
                    public Viewer createViewer(final Composite composite) {
                        return new TreeViewer(composite);
                    }

                    @Override
                    public void requestActivation() {
                        super.requestActivation();
                        setCurrentViewerPane(this);
                    }
                };
                viewerPane.createControl(getContainer());
                this.treeViewer = (TreeViewer) viewerPane.getViewer();
                this.treeViewer.setContentProvider(new AdapterFactoryContentProvider(this.adapterFactory));
                this.treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(this.adapterFactory));

                new AdapterFactoryTreeEditor(this.treeViewer.getTree(), this.adapterFactory);

                createContextMenuFor(this.treeViewer);
                final int pageIndex = addPage(viewerPane.getControl());
                setPageText(pageIndex, getString("_UI_TreePage_label"));
            }

            // This is the page for the table viewer.
            //
            {
                final ViewerPane viewerPane = new ViewerPane(getSite().getPage(), AllocationEditor.this) {

                    @Override
                    public Viewer createViewer(final Composite composite) {
                        return new TableViewer(composite);
                    }

                    @Override
                    public void requestActivation() {
                        super.requestActivation();
                        setCurrentViewerPane(this);
                    }
                };
                viewerPane.createControl(getContainer());
                this.tableViewer = (TableViewer) viewerPane.getViewer();

                final Table table = this.tableViewer.getTable();
                final TableLayout layout = new TableLayout();
                table.setLayout(layout);
                table.setHeaderVisible(true);
                table.setLinesVisible(true);

                final TableColumn objectColumn = new TableColumn(table, SWT.NONE);
                layout.addColumnData(new ColumnWeightData(3, 100, true));
                objectColumn.setText(getString("_UI_ObjectColumn_label"));
                objectColumn.setResizable(true);

                final TableColumn selfColumn = new TableColumn(table, SWT.NONE);
                layout.addColumnData(new ColumnWeightData(2, 100, true));
                selfColumn.setText(getString("_UI_SelfColumn_label"));
                selfColumn.setResizable(true);

                this.tableViewer.setColumnProperties(new String[] { "a", "b" });
                this.tableViewer.setContentProvider(new AdapterFactoryContentProvider(this.adapterFactory));
                this.tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(this.adapterFactory));

                createContextMenuFor(this.tableViewer);
                final int pageIndex = addPage(viewerPane.getControl());
                setPageText(pageIndex, getString("_UI_TablePage_label"));
            }

            // This is the page for the table tree viewer.
            //
            {
                final ViewerPane viewerPane = new ViewerPane(getSite().getPage(), AllocationEditor.this) {

                    @Override
                    public Viewer createViewer(final Composite composite) {
                        return new TreeViewer(composite);
                    }

                    @Override
                    public void requestActivation() {
                        super.requestActivation();
                        setCurrentViewerPane(this);
                    }
                };
                viewerPane.createControl(getContainer());

                this.treeViewerWithColumns = (TreeViewer) viewerPane.getViewer();

                final Tree tree = this.treeViewerWithColumns.getTree();
                tree.setLayoutData(new FillLayout());
                tree.setHeaderVisible(true);
                tree.setLinesVisible(true);

                final TreeColumn objectColumn = new TreeColumn(tree, SWT.NONE);
                objectColumn.setText(getString("_UI_ObjectColumn_label"));
                objectColumn.setResizable(true);
                objectColumn.setWidth(250);

                final TreeColumn selfColumn = new TreeColumn(tree, SWT.NONE);
                selfColumn.setText(getString("_UI_SelfColumn_label"));
                selfColumn.setResizable(true);
                selfColumn.setWidth(200);

                this.treeViewerWithColumns.setColumnProperties(new String[] { "a", "b" });
                this.treeViewerWithColumns.setContentProvider(new AdapterFactoryContentProvider(this.adapterFactory));
                this.treeViewerWithColumns.setLabelProvider(new AdapterFactoryLabelProvider(this.adapterFactory));

                createContextMenuFor(this.treeViewerWithColumns);
                final int pageIndex = addPage(viewerPane.getControl());
                setPageText(pageIndex, getString("_UI_TreeWithColumnsPage_label"));
            }

            getSite().getShell().getDisplay().asyncExec(new Runnable() {

                @Override
                public void run() {
                    setActivePage(0);
                }
            });
        }

        // Ensures that this editor will only display the page's tab
        // area if there are more than one page
        //
        getContainer().addControlListener(new ControlAdapter() {

            boolean guard = false;

            @Override
            public void controlResized(final ControlEvent event) {
                if (!this.guard) {
                    this.guard = true;
                    hideTabs();
                    this.guard = false;
                }
            }
        });

        getSite().getShell().getDisplay().asyncExec(new Runnable() {

            @Override
            public void run() {
                updateProblemIndication();
            }
        });
    }

    /**
     * @generated
     */
    protected void hideTabs() {
        if (getPageCount() <= 1) {
            setPageText(0, "");
            if (getContainer() instanceof CTabFolder) {
                ((CTabFolder) getContainer()).setTabHeight(1);
                final Point point = getContainer().getSize();
                getContainer().setSize(point.x, point.y + 6);
            }
        }
    }

    /**
     * @generated
     */
    protected void showTabs() {
        if (getPageCount() > 1) {
            setPageText(0, getString("_UI_SelectionPage_label"));
            if (getContainer() instanceof CTabFolder) {
                ((CTabFolder) getContainer()).setTabHeight(SWT.DEFAULT);
                final Point point = getContainer().getSize();
                getContainer().setSize(point.x, point.y - 6);
            }
        }
    }

    /**
     * @generated
     */
    @Override
    protected void pageChange(final int pageIndex) {
        super.pageChange(pageIndex);

        if (this.contentOutlinePage != null) {
            handleContentOutlineSelection(this.contentOutlinePage.getSelection());
        }
    }

    /**
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object getAdapter(final Class key) {
        if (key.equals(IContentOutlinePage.class)) {
            return showOutlineView() ? getContentOutlinePage() : null;
        } else if (key.equals(IPropertySheetPage.class)) {
            return getPropertySheetPage();
        } else if (key.equals(IGotoMarker.class)) {
            return this;
        } else {
            return super.getAdapter(key);
        }
    }

    /**
     * @generated
     */
    public IContentOutlinePage getContentOutlinePage() {
        if (this.contentOutlinePage == null) {
            // The content outline is just a tree.
            //
            class MyContentOutlinePage extends ContentOutlinePage {

                @Override
                public void createControl(final Composite parent) {
                    super.createControl(parent);
                    AllocationEditor.this.contentOutlineViewer = getTreeViewer();
                    AllocationEditor.this.contentOutlineViewer.addSelectionChangedListener(this);

                    // Set up the tree viewer.
                    //
                    AllocationEditor.this.contentOutlineViewer.setContentProvider(new AdapterFactoryContentProvider(
                            AllocationEditor.this.adapterFactory));
                    AllocationEditor.this.contentOutlineViewer.setLabelProvider(new AdapterFactoryLabelProvider(
                            AllocationEditor.this.adapterFactory));
                    AllocationEditor.this.contentOutlineViewer.setInput(AllocationEditor.this.editingDomain
                            .getResourceSet());

                    // Make sure our popups work.
                    //
                    createContextMenuFor(AllocationEditor.this.contentOutlineViewer);

                    if (!AllocationEditor.this.editingDomain.getResourceSet().getResources().isEmpty()) {
                        // Select the root object in the view.
                        //
                        AllocationEditor.this.contentOutlineViewer.setSelection(new StructuredSelection(
                                AllocationEditor.this.editingDomain.getResourceSet().getResources().get(0)), true);
                    }
                }

                @Override
                public void makeContributions(final IMenuManager menuManager, final IToolBarManager toolBarManager,
                        final IStatusLineManager statusLineManager) {
                    super.makeContributions(menuManager, toolBarManager, statusLineManager);
                    AllocationEditor.this.contentOutlineStatusLineManager = statusLineManager;
                }

                @Override
                public void setActionBars(final IActionBars actionBars) {
                    super.setActionBars(actionBars);
                    getActionBarContributor().shareGlobalActions(this, actionBars);
                }
            }

            this.contentOutlinePage = new MyContentOutlinePage();

            // Listen to selection so that we can handle it is a special way.
            //
            this.contentOutlinePage.addSelectionChangedListener(new ISelectionChangedListener() {

                // This ensures that we handle selections correctly.
                //
                @Override
                public void selectionChanged(final SelectionChangedEvent event) {
                    handleContentOutlineSelection(event.getSelection());
                }
            });
        }

        return this.contentOutlinePage;
    }

    /**
     * @generated
     */
    public IPropertySheetPage getPropertySheetPage() {
        final PropertySheetPage propertySheetPage = new ExtendedPropertySheetPage(this.editingDomain) {

            @Override
            public void setSelectionToViewer(final List<?> selection) {
                AllocationEditor.this.setSelectionToViewer(selection);
                AllocationEditor.this.setFocus();
            }

            @Override
            public void setActionBars(final IActionBars actionBars) {
                super.setActionBars(actionBars);
                getActionBarContributor().shareGlobalActions(this, actionBars);
            }
        };
        propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(this.adapterFactory));
        this.propertySheetPages.add(propertySheetPage);

        return propertySheetPage;
    }

    /**
     * @generated
     */
    public void handleContentOutlineSelection(final ISelection selection) {
        if (this.currentViewerPane != null && !selection.isEmpty() && selection instanceof IStructuredSelection) {
            final Iterator<?> selectedElements = ((IStructuredSelection) selection).iterator();
            if (selectedElements.hasNext()) {
                // Get the first selected element.
                //
                final Object selectedElement = selectedElements.next();

                // If it's the selection viewer, then we want it to select the same selection as
                // this selection.
                //
                if (this.currentViewerPane.getViewer() == this.selectionViewer) {
                    final ArrayList<Object> selectionList = new ArrayList<Object>();
                    selectionList.add(selectedElement);
                    while (selectedElements.hasNext()) {
                        selectionList.add(selectedElements.next());
                    }

                    // Set the selection to the widget.
                    //
                    this.selectionViewer.setSelection(new StructuredSelection(selectionList));
                } else {
                    // Set the input to the widget.
                    //
                    if (this.currentViewerPane.getViewer().getInput() != selectedElement) {
                        this.currentViewerPane.getViewer().setInput(selectedElement);
                        this.currentViewerPane.setTitle(selectedElement);
                    }
                }
            }
        }
    }

    /**
     * @generated
     */
    @Override
    public boolean isDirty() {
        return ((BasicCommandStack) this.editingDomain.getCommandStack()).isSaveNeeded();
    }

    /**
     * @generated
     */
    @Override
    public void doSave(final IProgressMonitor progressMonitor) {
        // Save only resources that have actually changed.
        //
        final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
        saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

        // Do the work within an operation because this is a long running activity that modifies the
        // workbench.
        //
        final WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {

            // This is the method that gets invoked when the operation runs.
            //
            @Override
            public void execute(final IProgressMonitor monitor) {
                // Save the resources to the file system.
                //
                boolean first = true;
                for (final Resource resource : AllocationEditor.this.editingDomain.getResourceSet().getResources()) {
                    if ((first || !resource.getContents().isEmpty() || isPersisted(resource))
                            && !AllocationEditor.this.editingDomain.isReadOnly(resource)) {
                        try {
                            final long timeStamp = resource.getTimeStamp();
                            resource.save(saveOptions);
                            if (resource.getTimeStamp() != timeStamp) {
                                AllocationEditor.this.savedResources.add(resource);
                            }
                        } catch (final Exception exception) {
                            AllocationEditor.this.resourceToDiagnosticMap.put(resource,
                                    analyzeResourceProblems(resource, exception));
                        }
                        first = false;
                    }
                }
            }
        };

        this.updateProblemIndication = false;
        try {
            // This runs the options, and shows progress.
            //
            new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);

            // Refresh the necessary state.
            //
            ((BasicCommandStack) this.editingDomain.getCommandStack()).saveIsDone();
            firePropertyChange(IEditorPart.PROP_DIRTY);
        } catch (final Exception exception) {
            // Something went wrong that shouldn't.
            //
            PalladioComponentModelEditorPlugin.INSTANCE.log(exception);
        }
        this.updateProblemIndication = true;
        updateProblemIndication();
    }

    /**
     * @generated
     */
    protected boolean isPersisted(final Resource resource) {
        boolean result = false;
        try {
            final InputStream stream = this.editingDomain.getResourceSet().getURIConverter()
                    .createInputStream(resource.getURI());
            if (stream != null) {
                result = true;
                stream.close();
            }
        } catch (final IOException e) {
            // Ignore
        }
        return result;
    }

    /**
     * @generated
     */
    @Override
    public boolean isSaveAsAllowed() {
        return true;
    }

    /**
     * @generated
     */
    @Override
    public void doSaveAs() {
        final SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
        saveAsDialog.open();
        final IPath path = saveAsDialog.getResult();
        if (path != null) {
            final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
            if (file != null) {
                doSaveAs(URI.createPlatformResourceURI(file.getFullPath().toString(), true), new FileEditorInput(file));
            }
        }
    }

    /**
     * @generated
     */
    protected void doSaveAs(final URI uri, final IEditorInput editorInput) {
        (this.editingDomain.getResourceSet().getResources().get(0)).setURI(uri);
        setInputWithNotify(editorInput);
        setPartName(editorInput.getName());
        final IProgressMonitor progressMonitor = getActionBars().getStatusLineManager() != null ? getActionBars()
                .getStatusLineManager().getProgressMonitor() : new NullProgressMonitor();
        doSave(progressMonitor);
    }

    /**
     * @generated
     */
    @Override
    public void gotoMarker(final IMarker marker) {
        final List<?> targetObjects = this.markerHelper.getTargetObjects(this.editingDomain, marker);
        if (!targetObjects.isEmpty()) {
            setSelectionToViewer(targetObjects);
        }
    }

    /**
     * @generated
     */
    @Override
    public void init(final IEditorSite site, final IEditorInput editorInput) {
        setSite(site);
        setInputWithNotify(editorInput);
        setPartName(editorInput.getName());
        site.setSelectionProvider(this);
        site.getPage().addPartListener(this.partListener);
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this.resourceChangeListener,
                IResourceChangeEvent.POST_CHANGE);
    }

    /**
     * @generated
     */
    @Override
    public void setFocus() {
        if (this.currentViewerPane != null) {
            this.currentViewerPane.setFocus();
        } else {
            getControl(getActivePage()).setFocus();
        }
    }

    /**
     * @generated
     */
    @Override
    public void addSelectionChangedListener(final ISelectionChangedListener listener) {
        this.selectionChangedListeners.add(listener);
    }

    /**
     * @generated
     */
    @Override
    public void removeSelectionChangedListener(final ISelectionChangedListener listener) {
        this.selectionChangedListeners.remove(listener);
    }

    /**
     * @generated
     */
    @Override
    public ISelection getSelection() {
        return this.editorSelection;
    }

    /**
     * @generated
     */
    @Override
    public void setSelection(final ISelection selection) {
        this.editorSelection = selection;

        for (final ISelectionChangedListener listener : this.selectionChangedListeners) {
            listener.selectionChanged(new SelectionChangedEvent(this, selection));
        }
        setStatusLineManager(selection);
    }

    /**
     * @generated
     */
    public void setStatusLineManager(final ISelection selection) {
        final IStatusLineManager statusLineManager = this.currentViewer != null
                && this.currentViewer == this.contentOutlineViewer ? this.contentOutlineStatusLineManager
                : getActionBars().getStatusLineManager();

        if (statusLineManager != null) {
            if (selection instanceof IStructuredSelection) {
                final Collection<?> collection = ((IStructuredSelection) selection).toList();
                switch (collection.size()) {
                case 0: {
                    statusLineManager.setMessage(getString("_UI_NoObjectSelected"));
                    break;
                }
                case 1: {
                    final String text = new AdapterFactoryItemDelegator(this.adapterFactory).getText(collection
                            .iterator().next());
                    statusLineManager.setMessage(getString("_UI_SingleObjectSelected", text));
                    break;
                }
                default: {
                    statusLineManager.setMessage(getString("_UI_MultiObjectSelected",
                            Integer.toString(collection.size())));
                    break;
                }
                }
            } else {
                statusLineManager.setMessage("");
            }
        }
    }

    /**
     * @generated
     */
    private static String getString(final String key) {
        return PalladioComponentModelEditorPlugin.INSTANCE.getString(key);
    }

    /**
     * @generated
     */
    private static String getString(final String key, final Object s1) {
        return PalladioComponentModelEditorPlugin.INSTANCE.getString(key, new Object[] { s1 });
    }

    /**
     * @generated
     */
    @Override
    public void menuAboutToShow(final IMenuManager menuManager) {
        ((IMenuListener) getEditorSite().getActionBarContributor()).menuAboutToShow(menuManager);
    }

    /**
     * @generated
     */
    public EditingDomainActionBarContributor getActionBarContributor() {
        return (EditingDomainActionBarContributor) getEditorSite().getActionBarContributor();
    }

    /**
     * @generated
     */
    public IActionBars getActionBars() {
        return getActionBarContributor().getActionBars();
    }

    /**
     * @generated
     */
    public AdapterFactory getAdapterFactory() {
        return this.adapterFactory;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated not
     */
    @Override
    public void dispose() {
        this.updateProblemIndication = false;

        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this.resourceChangeListener);

        this.getSite().getPage().removePartListener(this.partListener);

        ((IDisposable) this.adapterFactory).dispose();

        if (this.getActionBarContributor().getActiveEditor() == this) {
            this.getActionBarContributor().setActiveEditor(null);
        }

        for (final PropertySheetPage propertySheetPage : this.propertySheetPages) {
            propertySheetPage.dispose();
        }

        if (this.contentOutlinePage != null) {
            this.contentOutlinePage.dispose();
        }

        super.dispose();
    }

    /**
     * @generated
     */
    protected boolean showOutlineView() {
        return true;
    }
}
