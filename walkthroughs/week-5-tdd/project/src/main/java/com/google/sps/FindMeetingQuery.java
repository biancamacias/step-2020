// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class FindMeetingQuery {
  public Collection<TimeRange> query(Collection<Event> events, MeetingRequest request) {
    Collection<String> attendees = request.getAttendees();
    long durationOfMeeting = request.getDuration();
    List<TImeRange> freeTimeRanges = findFreeTimeRanges(events, attendees, duration);
    return freeTimeRanges;
  }

  private static List<TimeRange> sortTimesByStart(List<TimeRange> timeRanges) {
    Collections.sort(timeRanges, TimeRange.ORDER_BY_START);
    return timeRanges;
  }

  private static List<Event> sortEventsByStart(List<Event> events) {
    Collections.sort(events, Event.ORDER_BY_START);
    return sortedEventsByStart;
  }

  private static List<TimeRange> findSortedBusyTimeRanges(
      Collection<Event> events, Collection<String> attendees) {
    // maybe not best implementation considering runtime?
    List<TimeRange> sortedBusyTimeRanges = new ArrayList<>();
    for (Event event : events) {
      for (String attendee : attendees) {
        if (event.getAttendees().contains(attendee)) {
          sortedBusyTimeRanges.add(event.getWhen());
        }
      }
    }
    return sortTimesByStart(sortedBusyTimeRanges);
  }

  // TODO(biancamacias) finish implementing ---->
  private static List<TimeRange> findFreeTimeRanges(
      Collection<Event> events, Collection<String> attendees, long duration) {
    List<TimeRange> freeTimeRanges = new ArrayList<>();
    int start = TimeRange.START_OF_DAY;
    int end = TimeRange.END_OF_DAY;
    int allday = TimeRange.WHOLE_DAY;
    int minutesStart = 1440;

    // edge cases before continuing
    if (events.isEmpty() || events == null || attendees.isEmpty() || attendees == null) {
      freeTimeRanges.add(allday);
      return freeTimeRanges;
    }

    if (duration > minutesStart) {
      return freeTimeRanges;
    }

    List<TimeRange> busyTimeRanges = findSortedBusyTimeRanges(events, attendees);
    List<Event> sortedEvents = sortEventsByStart(events);
    // TODO(biancamacias): for loop or while loop, which checks if time is in closed time ranges or
    // not
    // TODO(biancamacias): if when meeting starts < start, make the bigger of the two the new start
    // TODO(biancamacias): if start and duration of meeting are <= meeting start, then add time
    // range
    // TODO(biancamacias): if start and duration <= end of day, add time range
  }
}
