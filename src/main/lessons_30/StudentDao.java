package lessons_30;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class StudentDao implements GenericDao<Student, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Student entity) {
        entityManager.persist(entity);
    }

    @Override
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student findByEmail(String email) {
        return entityManager.createQuery("SELECT s FROM Student s WHERE s.email = :email", Student.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public Student update(Student entity) {
        return entityManager.merge(entity);
    }

    @Override
    public boolean deleteById(Long id) {
        Student student = findById(id);
        if (student != null) {
            entityManager.remove(student);
            return true;
        }
        return false;
    }
}
