package de.uka.ipd.sdq.pcm.dialogs.seff;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.dialogs.OpenStoExDialog;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

// TODO: Auto-generated Javadoc
// Manually written open policy to open the StoEx Dialog. It's
// called via a CustomBehaviour in the genmap
/**
 * The Class OpenLoopIterationsDialog.
 */
public class OpenLoopIterationsDialog extends OpenStoExDialog {

    /**
     * Gets the random variable.
     *
     * @param parent the parent
     * @return the random variable
     * @see de.uka.ipd.sdq.pcm.dialogs.OpenStoExDialog#getRandomVariable(org.eclipse.emf.ecore.EObject)
     */
    @Override
    protected RandomVariable getRandomVariable(EObject parent) {
        LoopAction loop = (LoopAction) parent;
        RandomVariable rv = loop.getIterationCount_LoopAction();
        return rv;
    }

    /**
     * Gets the expected type.
     *
     * @param rv the rv
     * @return the expected type
     * @see de.uka.ipd.sdq.pcm.dialogs.OpenStoExDialog#getExpectedType(de.uka.ipd.sdq.stoex.RandomVariable)
     */
    @Override
    protected TypeEnum getExpectedType(RandomVariable rv) {
        return TypeEnum.INT;
    }

}
