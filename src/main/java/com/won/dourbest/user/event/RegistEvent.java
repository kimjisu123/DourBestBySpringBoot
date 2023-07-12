package com.won.dourbest.user.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class RegistEvent {
    private int memberCode;
    public RegistEvent(int memberCode) {
        this.memberCode = memberCode;
    }
}
