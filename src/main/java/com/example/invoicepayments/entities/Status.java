package com.example.invoicepayments.entities;

import com.example.invoicepayments.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Status{

    public static final int RETRIES_LIMIT = 3;

    private State state;
    private int retries;

    public Status() {
        this.state = State.UNPROCESSED;
        this.retries = 0;
    }

}
