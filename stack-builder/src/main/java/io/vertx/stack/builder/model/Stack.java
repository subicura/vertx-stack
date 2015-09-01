/*
 *  Copyright (c) 2011-2015 The original author or authors
 *  ------------------------------------------------------
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *       The Eclipse Public License is available at
 *       http://www.eclipse.org/legal/epl-v10.html
 *
 *       The Apache License v2.0 is available at
 *       http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.stack.builder.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a vert.x stack.
 *
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class Stack {

  public final static String DOT_STACK_FILE_NAME = ".stack.json";

  /**
   * The output directory.
   */
  private File directory;

  private File descriptor;

  /**
   * The base / from stack.
   */
  private BaseStackDependency from;

  /**
   * The dependencies to add.
   */
  private List<StackDependency> dependencies = new ArrayList<>();

  /**
   * The additional files to add.
   */
  private List<AdditionalFile> files = new ArrayList<>();

  public List<StackArtifact> getArtifacts() {
    return artifacts;
  }

  public Stack setArtifacts(List<StackArtifact> artifacts) {
    this.artifacts = artifacts;
    return this;
  }

  /**
   * The list of artifacts, usually read from
   */
  private List<StackArtifact> artifacts = new ArrayList<>();

  /**
   * Gets the 'inherited' stack. It can be {@code null} if the stack is already installed the the specified directory.
   *
   * @return the {@link BaseStackDependency}, {@code null} if none.
   */
  public BaseStackDependency getFrom() {
    return from;
  }

  /**
   * Sets the inherited stack.
   *
   * @param base the stack
   * @return the current {@link BaseStackDependency}
   */
  public Stack setFrom(BaseStackDependency base) {
    this.from = base;
    return this;
  }

  /**
   * Gets the list of dependencies.
   *
   * @return the list of dependency, empty if none.
   */
  public List<StackDependency> getDependencies() {
    return dependencies;
  }

  /**
   * Sets the list of dependencies.
   *
   * @param dependencies the dependencies, must not be {@code null}
   * @return the current {@link BaseStackDependency}
   */
  public Stack setDependencies(List<StackDependency> dependencies) {
    Objects.requireNonNull(dependencies);
    this.dependencies = dependencies;
    return this;
  }

  /**
   * Gets the base directory where the stack will be unpacked or already installed.
   *
   * @return the base directory.
   */
  public File getDirectory() {
    return directory;
  }

  /**
   * Sets the base directory.
   *
   * @param directory the directory, must not be {@code null}
   * @return the current {@link BaseStackDependency}
   */
  public Stack setDirectory(File directory) {
    this.directory = directory;
    return this;
  }

  /**
   * Gets the list of additional files to add to the stack.
   *
   * @return the list of {@link AdditionalFile}
   */
  public List<AdditionalFile> getFiles() {
    return files;
  }

  /**
   * Sets the list of additional file to add to the stack.
   *
   * @param files the files
   * @return the current {@link BaseStackDependency}
   */
  public Stack setFiles(List<AdditionalFile> files) {
    this.files = files;
    return this;
  }

  /**
   * Adds a single dependency to the list of dependency.
   *
   * @param dependency the dependency
   * @return the current {@link BaseStackDependency}
   */
  public Stack addDependency(StackDependency dependency) {
    this.dependencies.add(dependency);
    return this;
  }

  /**
   * Adds a file to the list of {@link AdditionalFile}.
   *
   * @param file the file
   * @return the current {@link BaseStackDependency}
   */
  public Stack addFile(AdditionalFile file) {
    this.files.add(file);
    return this;
  }

  public void addArtifact(StackArtifact stackArtifact) {
    this.artifacts.add(stackArtifact);
  }

  public File getDescriptor() {
    return descriptor;
  }

  public Stack setDescriptor(File descriptor) {
    this.descriptor = descriptor;
    return this;
  }
}