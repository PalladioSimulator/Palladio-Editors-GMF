package org.palladiosimulator.pcm.dialogs.seff;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.dialogs.OpenStoExDialog;

import org.palladiosimulator.pcm.seff.seff_performance.InfrastructureCall;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

// TODO: Auto-generated Javadoc
// Manually written open policy to open the StoEx Dialog. It's
// called via a CustomBehaviour in the genmap
/**
 * The Class OpenInfrastructureCallNumberOfCallsDialog.
 */
public class OpenInfrastructureCallNumberOfCallsDialog extends OpenStoExDialog {

    /**
     * Gets the random variable.
     *
     * @param parent the parent
     * @return the random variable
     * @see org.palladiosimulator.pcm.dialogs.OpenStoExDialog#getRandomVariable(org.eclipse.emf.ecore.EObject)
     */
    @Override
    protected RandomVariable getRandomVariable(EObject parent) {
        InfrastructureCall call = (InfrastructureCall) parent;
        RandomVariable rv = call.getNumberOfCalls__InfrastructureCall();
        return rv;
    }

    /**
     * Gets the expected type.
     *
     * @param rv the rv
     * @return the expected type
     * @see org.palladiosimulator.pcm.dialogs.OpenStoExDialog#getExpectedType(de.uka.ipd.sdq.stoex.RandomVariable)
     */
    @Override
    protected TypeEnum getExpectedType(RandomVariable rv) {
        return TypeEnum.INT;
    }

}
