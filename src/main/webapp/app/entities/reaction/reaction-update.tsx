import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, Translate, translate, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IApplicationUser } from 'app/shared/model/application-user.model';
import { getEntities as getApplicationUsers } from 'app/entities/application-user/application-user.reducer';
import { IBlog } from 'app/shared/model/blog.model';
import { getEntities as getBlogs } from 'app/entities/blog/blog.reducer';
import { IReaction } from 'app/shared/model/reaction.model';
import { Emotion } from 'app/shared/model/enumerations/emotion.model';
import { getEntity, updateEntity, createEntity, reset } from './reaction.reducer';

export const ReactionUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const applicationUsers = useAppSelector(state => state.applicationUser.entities);
  const blogs = useAppSelector(state => state.blog.entities);
  const reactionEntity = useAppSelector(state => state.reaction.entity);
  const loading = useAppSelector(state => state.reaction.loading);
  const updating = useAppSelector(state => state.reaction.updating);
  const updateSuccess = useAppSelector(state => state.reaction.updateSuccess);
  const emotionValues = Object.keys(Emotion);

  const handleClose = () => {
    navigate('/reaction' + location.search);
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }

    dispatch(getApplicationUsers({}));
    dispatch(getBlogs({}));
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    const entity = {
      ...reactionEntity,
      ...values,
      applicationUser: applicationUsers.find(it => it.id.toString() === values.applicationUser.toString()),
      blog: blogs.find(it => it.id.toString() === values.blog.toString()),
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {}
      : {
          emotion: 'LIKE',
          ...reactionEntity,
          applicationUser: reactionEntity?.applicationUser?.id,
          blog: reactionEntity?.blog?.id,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="blogApp.reaction.home.createOrEditLabel" data-cy="ReactionCreateUpdateHeading">
            <Translate contentKey="blogApp.reaction.home.createOrEditLabel">Create or edit a Reaction</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? (
                <ValidatedField
                  name="id"
                  required
                  readOnly
                  id="reaction-id"
                  label={translate('global.field.id')}
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField
                label={translate('blogApp.reaction.emotion')}
                id="reaction-emotion"
                name="emotion"
                data-cy="emotion"
                type="select"
              >
                {emotionValues.map(emotion => (
                  <option value={emotion} key={emotion}>
                    {translate('blogApp.Emotion.' + emotion)}
                  </option>
                ))}
              </ValidatedField>
              <ValidatedField
                id="reaction-applicationUser"
                name="applicationUser"
                data-cy="applicationUser"
                label={translate('blogApp.reaction.applicationUser')}
                type="select"
                required
              >
                <option value="" key="0" />
                {applicationUsers
                  ? applicationUsers.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <FormText>
                <Translate contentKey="entity.validation.required">This field is required.</Translate>
              </FormText>
              <ValidatedField
                id="reaction-blog"
                name="blog"
                data-cy="blog"
                label={translate('blogApp.reaction.blog')}
                type="select"
                required
              >
                <option value="" key="0" />
                {blogs
                  ? blogs.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <FormText>
                <Translate contentKey="entity.validation.required">This field is required.</Translate>
              </FormText>
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/reaction" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default ReactionUpdate;
