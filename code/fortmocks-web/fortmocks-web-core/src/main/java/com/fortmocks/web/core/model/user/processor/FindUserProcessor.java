package com.fortmocks.web.core.model.user.processor;

import com.fortmocks.core.model.Processor;
import com.fortmocks.core.model.Result;
import com.fortmocks.core.model.Task;
import com.fortmocks.core.model.user.dto.UserDto;
import com.fortmocks.core.model.user.message.FindUserInput;
import com.fortmocks.core.model.user.message.FindUserOutput;
import org.springframework.stereotype.Service;

/**
 * @author Karl Dahlgren
 * @since 1.0
 */
@Service
public class FindUserProcessor extends AbstractUserProcessor implements Processor<FindUserInput, FindUserOutput> {

    /**
     * The process message is responsible for processing an incoming task and generate
     * a response based on the incoming task input
     * @param task The task that will be processed by the processor
     * @return A result based on the processed incoming task
     * @see Task
     * @see Result
     */
    @Override
    public Result<FindUserOutput> process(final Task<FindUserInput> task) {
        final FindUserInput input = task.getInput();
        final UserDto user = find(input.getUserId());
        final FindUserOutput output = new FindUserOutput();
        output.setUser(user);
        return createResult(output);
    }
}