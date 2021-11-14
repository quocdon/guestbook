package fsoft.guestbook.repository;

import fsoft.guestbook.entity.GuestbookEntry;
import org.springframework.data.repository.CrudRepository;

public interface GuestbookEntryRepository extends CrudRepository<GuestbookEntry, Long> {

}
