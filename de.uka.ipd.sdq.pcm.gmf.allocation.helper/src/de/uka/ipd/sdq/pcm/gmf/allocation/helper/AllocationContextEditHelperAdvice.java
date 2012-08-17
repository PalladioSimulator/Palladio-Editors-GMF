package de.uka.ipd.sdq.pcm.gmf.allocation.helper;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;

/**
 * Edit helper advice for Allocation Context. Creates an dialog and initializes allocation contexts
 * after their creation.
 * 
 */
public class AllocationContextEditHelperAdvice extends AbstractEditHelperAdvice {

    @Override
    protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {
        final PalladioSelectEObjectDialog dialog = this.constructDialog(request);
        dialog.open();
        return this.createCommandFromSelection(request, dialog);
    }

    /**
     * Constructs a selection dialog for selecting the appropriate assembly context.
     * 
     * @param request
     *            the configuration request
     * @return the created dialog
     */
    private PalladioSelectEObjectDialog constructDialog(final ConfigureRequest request) {
        final ArrayList<Object> filterList = new ArrayList<Object>();
        filterList.add(de.uka.ipd.sdq.pcm.system.System.class);
        filterList.add(AssemblyContext.class);

        final ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        final ResourceSet resourceSet = request.getElementToConfigure().eResource().getResourceSet();
        final PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(shell, filterList,
                additionalReferences, resourceSet);
        dialog.setProvidedService(AssemblyContext.class);
        return dialog;
    }

    /**
     * Returns the command corresponding to the selection.
     * 
     * @param request
     *            the configuration request
     * @param dialog
     *            the dialog which selection should be evaluated
     * @return the command corresponding to the selection
     */
    private ICommand createCommandFromSelection(final ConfigureRequest request, final PalladioSelectEObjectDialog dialog) {
        AssemblyContext resource;
        if (dialog.getResult() == null) {
            return new CanceledCommand();
        }
        if (!(dialog.getResult() instanceof AssemblyContext)) {
            return new CanceledCommand();
        }
        resource = (AssemblyContext) dialog.getResult();

        final CompositeCommand cc = this.constructInitializationCommand(request, resource);

        return cc;
    }

    /**
     * Constructs the commands to initialize the allocation context.
     * 
     * @param request
     *            the configuration request
     * @param resource
     *            the resource the allocation is to be associated with
     * @return the composite command containing all necessary commands
     */
    private CompositeCommand constructInitializationCommand(final ConfigureRequest request,
            final AssemblyContext resource) {
        final ICommand cmd = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                AllocationPackage.eINSTANCE.getAllocationContext_AssemblyContext_AllocationContext(), resource));

        String allocationName = "Allocation_" + resource.getEntityName();
        if (resource.getEncapsulatedComponent__AssemblyContext() != null) {
            allocationName += " <" + resource.getEncapsulatedComponent__AssemblyContext().getEntityName() + ">";
        }

        final ICommand cmd2 = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                EntityPackage.eINSTANCE.getNamedElement_EntityName(), allocationName));

        final CompositeCommand cc = new CompositeCommand("Configure Allocation Context");
        cc.add(cmd);
        cc.add(cmd2);
        return cc;
    }
}
