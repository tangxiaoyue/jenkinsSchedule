/*
 * The MIT License
 *
 * Copyright 2013 gardnerj.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.jenkins.jplugin.batchBuild;

import hudson.Extension;
import hudson.model.Job;
import hudson.model.JobProperty;
import hudson.model.JobPropertyDescriptor;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

/**
 *
 * @author gardnerj
 * @since 1.20
 */
public class BatchBuildSettings extends JobProperty<Job<?, ?>> {
    /**
     * boolean auto rebuild variable.
     */
    private boolean autoBatchbuild;
    private boolean batchBuildDisabled;
    /**
     * RebuildSettings constructor.
     *
     */
    @DataBoundConstructor
    public BatchBuildSettings(boolean autoBatchbuild, boolean batchBuildDisabled) {
        this.autoBatchbuild = autoBatchbuild;
        this.batchBuildDisabled = batchBuildDisabled;
    }
    /**
     * Method returns autoRebuild.
     *
     * @return autoRebuild boolean.
     */
    public boolean getAutoBatchBuild() {
        return autoBatchbuild;
    }
    
    /**
     * Method returns rebuildDisabled.
     *
     * @return rebuildDisabled boolean.
     */
    public boolean getBatchBuildDisabled() {
        return batchBuildDisabled;
    }
    
   /**
    * DescriptorImpl class of JobPropertyDescriptor.
    */
    @Extension
    public static final class DescriptorImpl extends JobPropertyDescriptor {

        @Override
        public String getDisplayName() {
            return "BatchBuild Settings";
        }

        @Override
        public boolean isApplicable(Class<? extends Job> jobType) {
            return true;
        }

        @Override
        public JobProperty<?> newInstance(StaplerRequest req, JSONObject formdata) {
            BatchBuildSettings prop = req.bindJSON(BatchBuildSettings.class, formdata);
            return prop;
        }
    }
}
