package org.sorinb.spring.training.repository;

import org.sorinb.spring.training.model.User;

/**
 * Created by sorinello on 3/31/17.
 */
public interface UserRepository {
    void save(final User user);
}
