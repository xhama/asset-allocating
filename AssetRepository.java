/**
 * Leverages JpaRepository to persist Asset data
 */
public interface AssetRepository extends JpaRepository<Asset, String> {

    // assuming unique IDs
    Asset findById(String id);

    List<Asset> findByGroup(String group_name);

    // have containing and equals methods for all fields 
    // find all Assets where queryString in name
    List<Asset> findByNameContaning(String queryString);

    List<Asset> findByName(String queryString);

    List<Asset> findByTag(String key, String value);

    List<Asset> findByType(String queryString);

    List<Asset> findByTypeContaining(String queryString);

    // ... can be extended to all fields
}