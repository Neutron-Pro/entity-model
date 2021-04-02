# EntityModel

Cette petite api permet d'ajouter des variables et/ou actions supplémentaires sur des entités sans devoir refaire constamment leurs gestionnaires.

# Créer une Entité

```java
import fr.neutronstars.api.model.EntityModel;

public class EntityExample extends EntityModel {
    
    private final int id;
    private final String name;

    public EntityExample(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }
}
```

# Création d'un Model pour la cible

```java
import fr.neutronstars.api.model.Model;

public class EntityExampleModel extends Model<EntityExample> {
    protected String email;

    public EntityExampleModel(EntityExample entity) {
        super(entity);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```

# Enregistrer un model à une entité

```java
EntityExample entity = new EntityExample();
try {
    entity.registerModel(EntityExampleModel.class);
} catch (ModelException exception) {
  exception.printStackTrace();    
}
```

# Récupérer un model d'une entité

```java
Optional<EntityExampleModel> optional = entity.getModel(EntityExampleModel.class);

if (optional.isPresent()) {
  EntityExampleModel model = optional.get();
}
```

# Supprimer un model d'une entité

```java
entity.removeModel(EntityExampleModel.class);
```