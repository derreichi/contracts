package de.reichi.database.event;

import de.reichi.database.entity.Contract;
import de.reichi.database.entity.ContractIndex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.kafka.core.KafkaTemplate;

@RepositoryEventHandler
public class ContractEventHandler {
  private static final Logger logger = LoggerFactory.getLogger(ContractEventHandler.class);

  @Autowired
  private ElasticsearchRestTemplate elastic;

  @Autowired
  private KafkaTemplate kafkaTemplate;

  @HandleAfterCreate
  public void handleContractAfterCreate(Contract contract){
    logger.info("Inside Contract After Create ....");
    logger.info(contract.getFirstname());
    this.elastic.save(
      new ContractIndex(contract.getId(), contract.getFirstname(),
        contract.getSurename(), contract.getEmail()));
    this.kafkaTemplate.send("contracts", contract);
  }
}
