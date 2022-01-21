package co.com.sofka.score.domain.generic;

import co.com.sofka.score.infra.generic.StoredEvent; //TODO: no cumple la regla de la dependecia

import java.util.List;

public interface EventStoreRepository {

    List<DomainEvent> getEventsBy(String aggregateName, String aggregateRootId);


    void saveEvent(String aggregateName, String aggregateRootId, StoredEvent storedEvent);

}