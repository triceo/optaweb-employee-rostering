/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaweb.employeerostering.service.skill;

import java.util.List;

import org.optaweb.employeerostering.domain.skill.Skill;
import org.optaweb.employeerostering.domain.skill.SkillDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/tenant/{tenantId}/skill")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
        Assert.notNull(skillService, "skillService must not be null.");
    }

    @GetMapping("/")
    public ResponseEntity<List<Skill>> getSkillList(@PathVariable Integer tenantId) {
        return new ResponseEntity<>(skillService.getSkillList(tenantId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkill(@PathVariable Integer tenantId, @PathVariable Long id) {
        return new ResponseEntity<>(skillService.getSkill(tenantId, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteSkill(@PathVariable Integer tenantId, @PathVariable Long id) {
        return new ResponseEntity<>(skillService.deleteSkill(tenantId, id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Skill> createSkill(@PathVariable Integer tenantId, @RequestBody SkillDTO skillDTO) {
        Skill skill = new Skill(skillDTO);
        return new ResponseEntity<>(skillService.createSkill(tenantId, skill), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Skill> updateSkill(@PathVariable Integer tenantId, @RequestBody SkillDTO skillDTO) {
        Skill skill = new Skill(skillDTO);
        return new ResponseEntity<>(skillService.updateSkill(tenantId, skill), HttpStatus.OK);
    }
}