package dev.alexmaramaldo.authenticator.services;

import org.springframework.stereotype.Service;

import dev.alexmaramaldo.authenticator.entities.ConfirmationToken;
import dev.alexmaramaldo.authenticator.repositories.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;


@Service
@AllArgsConstructor
public class ConfirmationTokenService {

	private final ConfirmationTokenRepository confirmationTokenRepository = null;

	public void saveConfirmationToken(ConfirmationToken confirmationToken) {

		confirmationTokenRepository.save(confirmationToken);
	}

	public void deleteConfirmationToken(Long id) {

		confirmationTokenRepository.deleteById(id);
	}


	public Optional<ConfirmationToken> findConfirmationTokenByToken(String token) {

		return confirmationTokenRepository.findConfirmationTokenByConfirmationToken(token);
	}

}
