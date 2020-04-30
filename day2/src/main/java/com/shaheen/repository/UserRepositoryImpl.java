package com.shaheen.repository;

import com.shaheen.model.User;

public class UserRepositoryImpl extends CrudImpl<User, Long> implements UserRepository {
    private static UserRepositoryImpl instance;

    public UserRepositoryImpl() {
        super();
    }

//    public static synchronized UserRepositoryImpl getInstance() {
//        return instance = Objects.requireNonNullElseGet(instance, UserRepositoryImpl::new);
//    }

//    @Override
//    public User findByMailAndPassword(String email, String password) throws NoResultException {
//        return (User) getEntityManager().createNamedQuery("User.findByEmailAndPassword")
//                .setParameter("email", email)
//                .setParameter("password", password).getSingleResult();
//    }

}
