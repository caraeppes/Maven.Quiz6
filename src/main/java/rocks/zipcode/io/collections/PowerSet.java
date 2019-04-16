package rocks.zipcode.io.collections;

import java.util.*;

/**
 * @author leon on 10/01/2019.
 */
public class PowerSet<TypeOfSet> {
    protected final Set<TypeOfSet> originalSet;

    public PowerSet(TypeOfSet[] originalSet) {
        this.originalSet = new HashSet<>(Arrays.asList(originalSet));
    }

    /**
     * @return the powerset of `originalSet`
     */
    public Set<Set<TypeOfSet>> permute() {
       return getPowerSet(originalSet);
    }

    public Set<Set<TypeOfSet>> getPowerSet(Set<TypeOfSet> set){
        Set<Set<TypeOfSet>> sets = new HashSet<>();
        if (set.isEmpty()) {
            sets.add(new HashSet<>());
            return sets;
        }
        List<TypeOfSet> list = new ArrayList<>(set);
        TypeOfSet head = list.get(0);
        Set<TypeOfSet> rest = new HashSet<>(list.subList(1, list.size()));
        for (Set<TypeOfSet> s : getPowerSet(rest)) {
            Set<TypeOfSet> newSet = new HashSet<>();
            newSet.add(head);
            newSet.addAll(s);
            sets.add(newSet);
            sets.add(s);
        }
        return sets;
    }

    /**
     * @return `originalSet`
     */
    public Set<TypeOfSet> getOriginalSet() {
        return originalSet;
    }
}
