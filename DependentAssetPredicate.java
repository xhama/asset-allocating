/**
 * A class containing compounded predicates, meaning they all must be true for the predicate to be true.
 * 
 * Essentially encapsulating an "and", so only true if (condition a && condition b && condition c) where all 3 are listed in the dependent_predicates field.
 */
public class DependentAssetPredicate {

    // all of these predicates must be true for the condition to be fulfilled
    //     e.g. prod in name, type == ec2-isntance would both have to be true for the predicate to be true, essentially representing an &&
    List<AssetPredicate> dependent_predicates;

   // getter and setter
    public List<DependentAssetPredicate> getDependentPredicates() {
        return predicates;
    }

    public void setPredicates(List<DependentAssetPredicate> predicates) {
        this.predicates = predicates;
    }

    /**
     * Helper method to evaluate the dependent predicate
     */
    public boolean evaluate(Asset asset) {
        for (predicate : dependent_predicates) {
            if (!predicate.evaluate(asset)) {
                return false;
            }
        }
        return true;
    }

}