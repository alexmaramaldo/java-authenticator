package dev.alexmaramaldo.authenticator.repositories;

import dev.alexmaramaldo.authenticator.entities.ConfirmationToken;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, Long> {

    public Optional<ConfirmationToken> findConfirmationTokenByConfirmationToken(String token);
}